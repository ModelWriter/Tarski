package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.List;

import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.BodySuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.DerivationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EAnnotationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EAttributeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EClassSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EClassifierSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EDataTypeSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EDetailSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EEnumLiteralSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EEnumSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EModelElementRefSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EModelElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.ENamedElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EOperationSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EPackageSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EParameterSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EReferenceSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.EStructuralFeatureSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.ETypedElementSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.ExpressionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.FormulaSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.IdentifierSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.InitialSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.InvariantSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.LowerSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.ModelSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.MultiplicitySuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.OptionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.OptionsSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.PackageImportSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.PathNameSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.PostconditionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.PreconditionSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.TemplateSignatureSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.UnrestrictedNameSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.UpperSuggestionProvider;
import eu.modelwriter.core.alloyinecore.ui.editor.completion.content.VisibilityKindSuggestionProvider;

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
      AIESuggestionProviderSingletonFactory.multiplicitySP = new MultiplicitySuggestionProvider();
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
    }
    return AIESuggestionProviderSingletonFactory.instance;
  }

  public AIESuggestionProvider BodySP() {
    return AIESuggestionProviderSingletonFactory.bodySP;
  }

  public AIESuggestionProvider DerivationSP() {
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

  public AIESuggestionProvider ExpressionSP() {
    return AIESuggestionProviderSingletonFactory.expressionSP;
  }

  public AIESuggestionProvider FormulaSP() {
    return AIESuggestionProviderSingletonFactory.formulaSP;
  }

  public AIESuggestionProvider IndentifierSP() {
    return AIESuggestionProviderSingletonFactory.indentifierSP;
  }

  public AIESuggestionProvider InitialSP() {
    return AIESuggestionProviderSingletonFactory.initialSP;
  }

  public AIESuggestionProvider InvariantSP() {
    return AIESuggestionProviderSingletonFactory.invariantSP;
  }

  public AIESuggestionProvider LowerSP() {
    return AIESuggestionProviderSingletonFactory.lowerSP;
  }

  public AIESuggestionProvider ModelSP() {
    return AIESuggestionProviderSingletonFactory.modelSP;
  }

  public AIESuggestionProvider MultiplicitySP() {
    return AIESuggestionProviderSingletonFactory.multiplicitySP;
  }

  public AIESuggestionProvider OptionsSP() {
    return AIESuggestionProviderSingletonFactory.optionsSP;
  }

  public AIESuggestionProvider OptionSP() {
    return AIESuggestionProviderSingletonFactory.optionSP;
  }

  public AIESuggestionProvider PackageImportSP() {
    return AIESuggestionProviderSingletonFactory.packageImportSP;
  }

  public AIESuggestionProvider PathNameSP() {
    return AIESuggestionProviderSingletonFactory.pathNameSP;
  }

  public AIESuggestionProvider PostconditionSP() {
    return AIESuggestionProviderSingletonFactory.postconditionSP;
  }

  public AIESuggestionProvider PreconditionSP() {
    return AIESuggestionProviderSingletonFactory.preconditionSP;
  }

  public AIESuggestionProvider TemplateSignatureSP() {
    return AIESuggestionProviderSingletonFactory.templateSignatureSP;
  }

  public AIESuggestionProvider UnrestrictedNameSP() {
    return AIESuggestionProviderSingletonFactory.unrestrictedNameSP;
  }

  public AIESuggestionProvider UpperSP() {
    return AIESuggestionProviderSingletonFactory.upperSP;
  }

  public AIESuggestionProvider VisibilityKindSP() {
    return AIESuggestionProviderSingletonFactory.visibilityKindSP;
  }

  public List<AIESuggestionProvider> allSuggestionProviders() {
    final List<AIESuggestionProvider> all = new ArrayList<>();
    all.add(BodySP());
    all.add(DerivationSP());
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
    all.add(ExpressionSP());
    all.add(FormulaSP());
    all.add(IndentifierSP());
    all.add(InitialSP());
    all.add(LowerSP());
    all.add(ModelSP());
    all.add(MultiplicitySP());
    all.add(OptionsSP());
    all.add(OptionSP());
    all.add(PackageImportSP());
    all.add(PathNameSP());
    all.add(PostconditionSP());
    all.add(PreconditionSP());
    all.add(TemplateSignatureSP());
    all.add(UnrestrictedNameSP());
    all.add(UpperSP());
    all.add(VisibilityKindSP());
    return all;
  }
}
