/*
 * 
 */
package ReqModel.diagram.part;

import java.util.ArrayList;
import java.util.Collections;

import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;

/**
 * @generated
 */
public class ReqModelPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createObjects1Group());
		paletteRoot.add(createConnections2Group());
	}

	/**
	 * Creates "Objects" palette tool group
	 * @generated
	 */
	private PaletteContainer createObjects1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				ReqModel.diagram.part.Messages.Objects1Group_title);
		paletteContainer.setId("createObjects1Group"); //$NON-NLS-1$
		paletteContainer.add(createProduct1CreationTool());
		paletteContainer.add(createRequirement2CreationTool());
		paletteContainer.add(createRequirementLevel3CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(
				ReqModel.diagram.part.Messages.Connections2Group_title);
		paletteContainer.setId("createConnections2Group"); //$NON-NLS-1$
		paletteContainer.add(createDependencyTo1CreationTool());
		paletteContainer.add(createRefine2CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createProduct1CreationTool() {
		ToolEntry entry = new ToolEntry(
				ReqModel.diagram.part.Messages.Product1CreationTool_title,
				ReqModel.diagram.part.Messages.Product1CreationTool_desc, null,
				null) {
		};
		entry.setId("createProduct1CreationTool"); //$NON-NLS-1$
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirement2CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_2002);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				ReqModel.diagram.part.Messages.Requirement2CreationTool_title,
				ReqModel.diagram.part.Messages.Requirement2CreationTool_desc,
				types);
		entry.setId("createRequirement2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ReqModel.diagram.providers.ReqModelElementTypes
				.getImageDescriptor(ReqModel.diagram.providers.ReqModelElementTypes.Requirement_3002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRequirementLevel3CreationTool() {
		ArrayList<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001);
		types.add(ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_3001);
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(
				ReqModel.diagram.part.Messages.RequirementLevel3CreationTool_title,
				ReqModel.diagram.part.Messages.RequirementLevel3CreationTool_desc,
				types);
		entry.setId("createRequirementLevel3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ReqModel.diagram.providers.ReqModelElementTypes
				.getImageDescriptor(ReqModel.diagram.providers.ReqModelElementTypes.RequirementLevel_2001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createDependencyTo1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				ReqModel.diagram.part.Messages.DependencyTo1CreationTool_title,
				ReqModel.diagram.part.Messages.DependencyTo1CreationTool_desc,
				Collections
						.singletonList(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002));
		entry.setId("createDependencyTo1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ReqModel.diagram.providers.ReqModelElementTypes
				.getImageDescriptor(ReqModel.diagram.providers.ReqModelElementTypes.RequirementDependencyTo_4002));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createRefine2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(
				ReqModel.diagram.part.Messages.Refine2CreationTool_title,
				ReqModel.diagram.part.Messages.Refine2CreationTool_desc,
				Collections
						.singletonList(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001));
		entry.setId("createRefine2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ReqModel.diagram.providers.ReqModelElementTypes
				.getImageDescriptor(ReqModel.diagram.providers.ReqModelElementTypes.RequirementRefine_4001));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

}
