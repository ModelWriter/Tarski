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

public class AIESuggestionProviderFactory {

  public AIESuggestionProvider bodySP() {
    return new BodySuggestionProvider();
  }

  public AIESuggestionProvider derivationSP() {
    return new DerivationSuggestionProvider();
  }

  public AIESuggestionProvider eAnnotationSP() {
    return new EAnnotationSuggestionProvider();
  }

  public AIESuggestionProvider eAttributeSP() {
    return new EAttributeSuggestionProvider();
  }

  public AIESuggestionProvider eClassifierSP() {
    return new EClassifierSuggestionProvider();
  }

  public AIESuggestionProvider eClassSP() {
    return new EClassSuggestionProvider();
  }

  public AIESuggestionProvider eDatatypeSP() {
    return new EDataTypeSuggestionProvider();
  }

  public AIESuggestionProvider eDetailSP() {
    return new EDetailSuggestionProvider();
  }

  public AIESuggestionProvider eEnumSP() {
    return new EEnumSuggestionProvider();
  }

  public AIESuggestionProvider eEnumliteralSP() {
    return new EEnumLiteralSuggestionProvider();
  }

  public AIESuggestionProvider eModelElementRefSP() {
    return new EModelElementRefSuggestionProvider();
  }

  public AIESuggestionProvider eModelElementSP() {
    return new EModelElementSuggestionProvider();
  }

  public AIESuggestionProvider eNamedElementSP() {
    return new ENamedElementSuggestionProvider();
  }

  public AIESuggestionProvider eOperationSP() {
    return new EOperationSuggestionProvider();
  }

  public AIESuggestionProvider ePackageSP() {
    return new EPackageSuggestionProvider();
  }

  public AIESuggestionProvider eParameterSP() {
    return new EParameterSuggestionProvider();
  }

  public AIESuggestionProvider eReferenceSP() {
    return new EReferenceSuggestionProvider();
  }

  public AIESuggestionProvider eStructuralFeatureSP() {
    return new EStructuralFeatureSuggestionProvider();
  }

  public AIESuggestionProvider eTypedElementSP() {
    return new ETypedElementSuggestionProvider();
  }

  public AIESuggestionProvider expressionSP() {
    return new ExpressionSuggestionProvider();
  }

  public AIESuggestionProvider formulaSP() {
    return new FormulaSuggestionProvider();
  }

  public AIESuggestionProvider indentifierSP() {
    return new IdentifierSuggestionProvider();
  }

  public AIESuggestionProvider initialSP() {
    return new InitialSuggestionProvider();
  }

  public AIESuggestionProvider invariantSP() {
    return new InvariantSuggestionProvider();
  }

  public AIESuggestionProvider lowerSP() {
    return new LowerSuggestionProvider();
  }

  public AIESuggestionProvider modelSP() {
    return new ModelSuggestionProvider();
  }

  public AIESuggestionProvider multiplicitySP() {
    return new EMultiplicitySuggestionProvider();
  }

  public AIESuggestionProvider optionsSP() {
    return new OptionsSuggestionProvider();
  }

  public AIESuggestionProvider optionSP() {
    return new OptionSuggestionProvider();
  }

  public AIESuggestionProvider packageImportSP() {
    return new PackageImportSuggestionProvider();
  }

  public AIESuggestionProvider pathNameSP() {
    return new PathNameSuggestionProvider();
  }

  public AIESuggestionProvider postconditionSP() {
    return new PostconditionSuggestionProvider();
  }

  public AIESuggestionProvider preconditionSP() {
    return new PreconditionSuggestionProvider();
  }

  public AIESuggestionProvider templateSignatureSP() {
    return new TemplateSignatureSuggestionProvider();
  }

  public AIESuggestionProvider unrestrictedNameSP() {
    return new UnrestrictedNameSuggestionProvider();
  }

  public AIESuggestionProvider upperSP() {
    return new UpperSuggestionProvider();
  }

  public AIESuggestionProvider visibilityKindSP() {
    return new VisibilityKindSuggestionProvider();
  }

  public AIESuggestionProvider eGenericExceptionSP() {
    return new EGenericExceptionSuggestionProvider();
  }

  public AIESuggestionProvider eGenericSuperTypeSP() {
    return new EGenericSuperTypeSuggestionProvider();
  }

  public AIESuggestionProvider eGenericTypeSP() {
    return new EGenericTypeSuggestionProvider();
  }

  public AIESuggestionProvider eGenericTypeArgumentSP() {
    return new EGenericTypeArgumentSuggestionProvider();
  }

  public AIESuggestionProvider ePrimitiveTypeSP() {
    return new EPrimitiveTypeSuggestionProvider();
  }

  public AIESuggestionProvider eGenericElementTypeSP() {
    return new EGenericElementTypeSuggestionProvider();
  }

  public AIESuggestionProvider eTypeParameterSP() {
    return new ETypeParameterSuggestionProvider();
  }

  public AIESuggestionProvider eGenericWildcardSP() {
    return new EGenericWildcardSuggestionProvider();
  }

  public AIESuggestionProvider segmentSP() {
    return new SegmentSuggestionProvider();
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
