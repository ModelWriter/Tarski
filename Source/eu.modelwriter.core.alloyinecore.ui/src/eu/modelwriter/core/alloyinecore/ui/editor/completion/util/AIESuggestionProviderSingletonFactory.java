package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.List;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.BodySuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.DerivationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EAnnotationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EAttributeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EClassSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EClassifierSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EDataTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EDetailSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EEnumLiteralSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EEnumSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericElementTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericExceptionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericSuperTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericTypeArgumentSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EGenericWildcardSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EModelElementRefSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EModelElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EMultiplicitySuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.ENamedElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EOperationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EPackageSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EParameterSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EPrimitiveTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EReferenceSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.EStructuralFeatureSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.ETypeParameterSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.ETypedElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.ExpressionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.FormulaSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.IdentifierSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.InitialSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.InvariantSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.LowerSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.ModelSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.OptionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.OptionsSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.PackageImportSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.PathNameSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.PostconditionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.PreconditionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.SegmentSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.TemplateSignatureSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.UnrestrictedNameSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.UpperSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.provider.VisibilityKindSuggestionProvider;

public class AIESuggestionProviderSingletonFactory {
  private static AIESuggestionProviderSingletonFactory instance;

  private static AIESuggestionProvider bodySP;
  private static AIESuggestionProvider derivationSP;
  private static AIESuggestionProvider eAnnotationSP;
  private static AIESuggestionProvider eAttributeSP;
  private static AIESuggestionProvider eClassifierSP;
  private static AIESuggestionProvider eClassSP;
  private static AIESuggestionProvider eDatatypeSP;
  private static AIESuggestionProvider eDetailSP;
  private static AIESuggestionProvider eEnumSP;
  private static AIESuggestionProvider eEnumliteralSP;
  private static AIESuggestionProvider eModelElementRefSP;
  private static AIESuggestionProvider eModelElementSP;
  private static AIESuggestionProvider eNamedElementSP;
  private static AIESuggestionProvider eOperationSP;
  private static AIESuggestionProvider ePackageSP;
  private static AIESuggestionProvider eParameterSP;
  private static AIESuggestionProvider eReferenceSP;
  private static AIESuggestionProvider eStructuralFeatureSP;
  private static AIESuggestionProvider eTypedElementSP;
  private static AIESuggestionProvider expressionSP;
  private static AIESuggestionProvider formulaSP;
  private static AIESuggestionProvider indentifierSP;
  private static AIESuggestionProvider initialSP;
  private static AIESuggestionProvider invariantSP;
  private static AIESuggestionProvider lowerSP;
  private static AIESuggestionProvider modelSP;
  private static AIESuggestionProvider multiplicitySP;
  private static AIESuggestionProvider optionsSP;
  private static AIESuggestionProvider optionSP;
  private static AIESuggestionProvider packageImportSP;
  private static AIESuggestionProvider pathNameSP;
  private static AIESuggestionProvider postconditionSP;
  private static AIESuggestionProvider preconditionSP;
  private static AIESuggestionProvider templateSignatureSP;
  private static AIESuggestionProvider unrestrictedNameSP;
  private static AIESuggestionProvider upperSP;
  private static AIESuggestionProvider visibilityKindSP;
  private static AIESuggestionProvider eGenericExceptionSP;
  private static AIESuggestionProvider eGenericSuperTypeSP;
  private static AIESuggestionProvider eGenericTypeSP;
  private static AIESuggestionProvider eGenericTypeArgumentSP;
  private static AIESuggestionProvider ePrimitiveTypeSP;
  private static AIESuggestionProvider eGenericElementTypeSP;
  private static AIESuggestionProvider eTypeParameterSP;
  private static AIESuggestionProvider eGenericWildcardSP;
  private static AIESuggestionProvider segmentSP;

  public static AIESuggestionProviderSingletonFactory instance() {
    if (AIESuggestionProviderSingletonFactory.instance == null) {
      AIESuggestionProviderSingletonFactory.instance = new AIESuggestionProviderSingletonFactory();
      AIESuggestionProviderSingletonFactory.bodySP = new BodySuggestionProvider();
      AIESuggestionProviderSingletonFactory.derivationSP = new DerivationSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eAnnotationSP = new EAnnotationSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eAttributeSP = new EAttributeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eClassifierSP = new EClassifierSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eClassSP = new EClassSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eDatatypeSP = new EDataTypeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eDetailSP = new EDetailSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eEnumSP = new EEnumSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eEnumliteralSP = new EEnumLiteralSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eModelElementRefSP =
          new EModelElementRefSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eModelElementSP = new EModelElementSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eNamedElementSP = new ENamedElementSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eOperationSP = new EOperationSuggestionProvider();
      AIESuggestionProviderSingletonFactory.ePackageSP = new EPackageSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eParameterSP = new EParameterSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eReferenceSP = new EReferenceSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eStructuralFeatureSP =
          new EStructuralFeatureSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eTypedElementSP = new ETypedElementSuggestionProvider();
      AIESuggestionProviderSingletonFactory.expressionSP = new ExpressionSuggestionProvider();
      AIESuggestionProviderSingletonFactory.formulaSP = new FormulaSuggestionProvider();
      AIESuggestionProviderSingletonFactory.indentifierSP = new IdentifierSuggestionProvider();
      AIESuggestionProviderSingletonFactory.initialSP = new InitialSuggestionProvider();
      AIESuggestionProviderSingletonFactory.invariantSP = new InvariantSuggestionProvider();
      AIESuggestionProviderSingletonFactory.lowerSP = new LowerSuggestionProvider();
      AIESuggestionProviderSingletonFactory.modelSP = new ModelSuggestionProvider();
      AIESuggestionProviderSingletonFactory.multiplicitySP = new EMultiplicitySuggestionProvider();
      AIESuggestionProviderSingletonFactory.optionsSP = new OptionsSuggestionProvider();
      AIESuggestionProviderSingletonFactory.optionSP = new OptionSuggestionProvider();
      AIESuggestionProviderSingletonFactory.packageImportSP = new PackageImportSuggestionProvider();
      AIESuggestionProviderSingletonFactory.pathNameSP = new PathNameSuggestionProvider();
      AIESuggestionProviderSingletonFactory.postconditionSP = new PostconditionSuggestionProvider();
      AIESuggestionProviderSingletonFactory.preconditionSP = new PreconditionSuggestionProvider();
      AIESuggestionProviderSingletonFactory.templateSignatureSP =
          new TemplateSignatureSuggestionProvider();
      AIESuggestionProviderSingletonFactory.unrestrictedNameSP =
          new UnrestrictedNameSuggestionProvider();
      AIESuggestionProviderSingletonFactory.upperSP = new UpperSuggestionProvider();
      AIESuggestionProviderSingletonFactory.visibilityKindSP =
          new VisibilityKindSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericExceptionSP =
          new EGenericExceptionSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericSuperTypeSP =
          new EGenericSuperTypeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericTypeSP = new EGenericTypeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericTypeArgumentSP =
          new EGenericTypeArgumentSuggestionProvider();
      AIESuggestionProviderSingletonFactory.ePrimitiveTypeSP =
          new EPrimitiveTypeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericElementTypeSP =
          new EGenericElementTypeSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eTypeParameterSP =
          new ETypeParameterSuggestionProvider();
      AIESuggestionProviderSingletonFactory.eGenericWildcardSP =
          new EGenericWildcardSuggestionProvider();
      AIESuggestionProviderSingletonFactory.segmentSP = new SegmentSuggestionProvider();
    }
    return AIESuggestionProviderSingletonFactory.instance;
  }

  public AIESuggestionProvider bodySP() {
    return AIESuggestionProviderSingletonFactory.bodySP;
  }

  public AIESuggestionProvider derivationSP() {
    return AIESuggestionProviderSingletonFactory.derivationSP;
  }

  public AIESuggestionProvider eAnnotationSP() {
    return AIESuggestionProviderSingletonFactory.eAnnotationSP;
  }

  public AIESuggestionProvider eAttributeSP() {
    return AIESuggestionProviderSingletonFactory.eAttributeSP;
  }

  public AIESuggestionProvider eClassifierSP() {
    return AIESuggestionProviderSingletonFactory.eClassifierSP;
  }

  public AIESuggestionProvider eClassSP() {
    return AIESuggestionProviderSingletonFactory.eClassSP;
  }

  public AIESuggestionProvider eDatatypeSP() {
    return AIESuggestionProviderSingletonFactory.eDatatypeSP;
  }

  public AIESuggestionProvider eDetailSP() {
    return AIESuggestionProviderSingletonFactory.eDetailSP;
  }

  public AIESuggestionProvider eEnumSP() {
    return AIESuggestionProviderSingletonFactory.eEnumSP;
  }

  public AIESuggestionProvider eEnumliteralSP() {
    return AIESuggestionProviderSingletonFactory.eEnumliteralSP;
  }

  public AIESuggestionProvider eModelElementRefSP() {
    return AIESuggestionProviderSingletonFactory.eModelElementRefSP;
  }

  public AIESuggestionProvider eModelElementSP() {
    return AIESuggestionProviderSingletonFactory.eModelElementSP;
  }

  public AIESuggestionProvider eNamedElementSP() {
    return AIESuggestionProviderSingletonFactory.eNamedElementSP;
  }

  public AIESuggestionProvider eOperationSP() {
    return AIESuggestionProviderSingletonFactory.eOperationSP;
  }

  public AIESuggestionProvider ePackageSP() {
    return AIESuggestionProviderSingletonFactory.ePackageSP;
  }

  public AIESuggestionProvider eParameterSP() {
    return AIESuggestionProviderSingletonFactory.eParameterSP;
  }

  public AIESuggestionProvider eReferenceSP() {
    return AIESuggestionProviderSingletonFactory.eReferenceSP;
  }

  public AIESuggestionProvider eStructuralFeatureSP() {
    return AIESuggestionProviderSingletonFactory.eStructuralFeatureSP;
  }

  public AIESuggestionProvider eTypedElementSP() {
    return AIESuggestionProviderSingletonFactory.eTypedElementSP;
  }

  public AIESuggestionProvider expressionSP() {
    return AIESuggestionProviderSingletonFactory.expressionSP;
  }

  public AIESuggestionProvider formulaSP() {
    return AIESuggestionProviderSingletonFactory.formulaSP;
  }

  public AIESuggestionProvider indentifierSP() {
    return AIESuggestionProviderSingletonFactory.indentifierSP;
  }

  public AIESuggestionProvider initialSP() {
    return AIESuggestionProviderSingletonFactory.initialSP;
  }

  public AIESuggestionProvider invariantSP() {
    return AIESuggestionProviderSingletonFactory.invariantSP;
  }

  public AIESuggestionProvider lowerSP() {
    return AIESuggestionProviderSingletonFactory.lowerSP;
  }

  public AIESuggestionProvider modelSP() {
    return AIESuggestionProviderSingletonFactory.modelSP;
  }

  public AIESuggestionProvider multiplicitySP() {
    return AIESuggestionProviderSingletonFactory.multiplicitySP;
  }

  public AIESuggestionProvider optionsSP() {
    return AIESuggestionProviderSingletonFactory.optionsSP;
  }

  public AIESuggestionProvider optionSP() {
    return AIESuggestionProviderSingletonFactory.optionSP;
  }

  public AIESuggestionProvider packageImportSP() {
    return AIESuggestionProviderSingletonFactory.packageImportSP;
  }

  public AIESuggestionProvider pathNameSP() {
    return AIESuggestionProviderSingletonFactory.pathNameSP;
  }

  public AIESuggestionProvider postconditionSP() {
    return AIESuggestionProviderSingletonFactory.postconditionSP;
  }

  public AIESuggestionProvider preconditionSP() {
    return AIESuggestionProviderSingletonFactory.preconditionSP;
  }

  public AIESuggestionProvider templateSignatureSP() {
    return AIESuggestionProviderSingletonFactory.templateSignatureSP;
  }

  public AIESuggestionProvider unrestrictedNameSP() {
    return AIESuggestionProviderSingletonFactory.unrestrictedNameSP;
  }

  public AIESuggestionProvider upperSP() {
    return AIESuggestionProviderSingletonFactory.upperSP;
  }

  public AIESuggestionProvider visibilityKindSP() {
    return AIESuggestionProviderSingletonFactory.visibilityKindSP;
  }

  public AIESuggestionProvider eGenericExceptionSP() {
    return AIESuggestionProviderSingletonFactory.eGenericExceptionSP;
  }

  public AIESuggestionProvider eGenericSuperTypeSP() {
    return AIESuggestionProviderSingletonFactory.eGenericSuperTypeSP;
  }

  public AIESuggestionProvider eGenericTypeSP() {
    return AIESuggestionProviderSingletonFactory.eGenericTypeSP;
  }

  public AIESuggestionProvider eGenericTypeArgumentSP() {
    return AIESuggestionProviderSingletonFactory.eGenericTypeArgumentSP;
  }

  public AIESuggestionProvider ePrimitiveTypeSP() {
    return AIESuggestionProviderSingletonFactory.ePrimitiveTypeSP;
  }

  public AIESuggestionProvider eGenericElementTypeSP() {
    return AIESuggestionProviderSingletonFactory.eGenericElementTypeSP;
  }

  public AIESuggestionProvider eTypeParameterSP() {
    return AIESuggestionProviderSingletonFactory.eTypeParameterSP;
  }

  public AIESuggestionProvider eGenericWildcardSP() {
    return AIESuggestionProviderSingletonFactory.eGenericWildcardSP;
  }

  public AIESuggestionProvider segmentSP() {
    return AIESuggestionProviderSingletonFactory.segmentSP;
  }

  public List<AIESuggestionProvider> allSuggestionProviders() {
    final List<AIESuggestionProvider> all = new ArrayList<>();
    all.add(bodySP());
    all.add(derivationSP());
    all.add(eAnnotationSP());
    all.add(eAttributeSP());
    all.add(eClassifierSP());
    all.add(eClassSP());
    all.add(eDatatypeSP());
    all.add(eDetailSP());
    all.add(eEnumSP());
    all.add(eEnumliteralSP());
    all.add(eModelElementRefSP());
    all.add(eModelElementSP());
    all.add(eNamedElementSP());
    all.add(eOperationSP());
    all.add(ePackageSP());
    all.add(eParameterSP());
    all.add(eReferenceSP());
    all.add(eStructuralFeatureSP());
    all.add(eTypedElementSP());
    all.add(expressionSP());
    all.add(formulaSP());
    all.add(indentifierSP());
    all.add(initialSP());
    all.add(lowerSP());
    all.add(modelSP());
    all.add(multiplicitySP());
    all.add(optionsSP());
    all.add(optionSP());
    all.add(packageImportSP());
    all.add(pathNameSP());
    all.add(postconditionSP());
    all.add(preconditionSP());
    all.add(templateSignatureSP());
    all.add(unrestrictedNameSP());
    all.add(upperSP());
    all.add(visibilityKindSP());
    all.add(eGenericExceptionSP());
    all.add(eGenericSuperTypeSP());
    all.add(eGenericTypeSP());
    all.add(eGenericTypeArgumentSP());
    all.add(ePrimitiveTypeSP());
    all.add(eGenericElementTypeSP());
    all.add(eTypeParameterSP());
    all.add(eGenericWildcardSP());
    all.add(segmentSP());
    return all;
  }
}
