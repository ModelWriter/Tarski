/*
 * 
 */
package ReqModel.diagram.providers;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.service.AbstractProvider;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.GetParserOperation;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParser;
import org.eclipse.gmf.runtime.common.ui.services.parser.IParserProvider;
import org.eclipse.gmf.runtime.common.ui.services.parser.ParserService;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.emf.ui.services.parser.ParserHintAdapter;
import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ReqModelParserProvider extends AbstractProvider implements
		IParserProvider {

	/**
	 * @generated
	 */
	private IParser requirementLevelName_5004Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementLevelName_5004Parser() {
		if (requirementLevelName_5004Parser == null) {
			EAttribute[] features = new EAttribute[] { ReqModel.ReqModelPackage.eINSTANCE
					.getNamedElement_Name() };
			ReqModel.diagram.parsers.MessageFormatParser parser = new ReqModel.diagram.parsers.MessageFormatParser(
					features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementLevelName_5004Parser = parser;
		}
		return requirementLevelName_5004Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementName_5005Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementName_5005Parser() {
		if (requirementName_5005Parser == null) {
			EAttribute[] features = new EAttribute[] { ReqModel.ReqModelPackage.eINSTANCE
					.getNamedElement_Name() };
			ReqModel.diagram.parsers.MessageFormatParser parser = new ReqModel.diagram.parsers.MessageFormatParser(
					features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementName_5005Parser = parser;
		}
		return requirementName_5005Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementLevelName_5003Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementLevelName_5003Parser() {
		if (requirementLevelName_5003Parser == null) {
			EAttribute[] features = new EAttribute[] { ReqModel.ReqModelPackage.eINSTANCE
					.getNamedElement_Name() };
			ReqModel.diagram.parsers.MessageFormatParser parser = new ReqModel.diagram.parsers.MessageFormatParser(
					features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementLevelName_5003Parser = parser;
		}
		return requirementLevelName_5003Parser;
	}

	/**
	 * @generated
	 */
	private IParser requirementName_5001Parser;

	/**
	 * @generated
	 */
	private IParser getRequirementName_5001Parser() {
		if (requirementName_5001Parser == null) {
			EAttribute[] features = new EAttribute[] { ReqModel.ReqModelPackage.eINSTANCE
					.getNamedElement_Name() };
			ReqModel.diagram.parsers.MessageFormatParser parser = new ReqModel.diagram.parsers.MessageFormatParser(
					features);
			parser.setViewPattern("{0}"); //$NON-NLS-1$
			parser.setEditorPattern("{0}"); //$NON-NLS-1$
			parser.setEditPattern("{0}"); //$NON-NLS-1$
			requirementName_5001Parser = parser;
		}
		return requirementName_5001Parser;
	}

	/**
	 * @generated
	 */
	protected IParser getParser(int visualID) {
		switch (visualID) {
		case ReqModel.diagram.edit.parts.RequirementLevelNameEditPart.VISUAL_ID:
			return getRequirementLevelName_5004Parser();
		case ReqModel.diagram.edit.parts.RequirementNameEditPart.VISUAL_ID:
			return getRequirementName_5005Parser();
		case ReqModel.diagram.edit.parts.RequirementLevelName2EditPart.VISUAL_ID:
			return getRequirementLevelName_5003Parser();
		case ReqModel.diagram.edit.parts.RequirementName2EditPart.VISUAL_ID:
			return getRequirementName_5001Parser();
		}
		return null;
	}

	/**
	 * Utility method that consults ParserService
	 * @generated
	 */
	public static IParser getParser(IElementType type, EObject object,
			String parserHint) {
		return ParserService.getInstance().getParser(
				new HintAdapter(type, object, parserHint));
	}

	/**
	 * @generated
	 */
	public IParser getParser(IAdaptable hint) {
		String vid = (String) hint.getAdapter(String.class);
		if (vid != null) {
			return getParser(ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(vid));
		}
		View view = (View) hint.getAdapter(View.class);
		if (view != null) {
			return getParser(ReqModel.diagram.part.ReqModelVisualIDRegistry
					.getVisualID(view));
		}
		return null;
	}

	/**
	 * @generated
	 */
	public boolean provides(IOperation operation) {
		if (operation instanceof GetParserOperation) {
			IAdaptable hint = ((GetParserOperation) operation).getHint();
			if (ReqModel.diagram.providers.ReqModelElementTypes
					.getElement(hint) == null) {
				return false;
			}
			return getParser(hint) != null;
		}
		return false;
	}

	/**
	 * @generated
	 */
	private static class HintAdapter extends ParserHintAdapter {

		/**
		 * @generated
		 */
		private final IElementType elementType;

		/**
		 * @generated
		 */
		public HintAdapter(IElementType type, EObject object, String parserHint) {
			super(object, parserHint);
			assert type != null;
			elementType = type;
		}

		/**
		 * @generated
		 */
		public Object getAdapter(Class adapter) {
			if (IElementType.class.equals(adapter)) {
				return elementType;
			}
			return super.getAdapter(adapter);
		}
	}

}
