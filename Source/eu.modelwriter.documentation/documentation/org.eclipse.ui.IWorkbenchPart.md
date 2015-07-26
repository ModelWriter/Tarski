==**org.eclipse.ui.IWorkbenchPart**===============================

A workbench part is a visual component within a workbench page. 
There are two subtypes: *view and editor*, as defined by **IViewPart** and **IEditorPart**. 

A view is typically used to navigate a hierarchy of information (like the workspace), open an editor, or display properties for the active editor. Modifications made in a view are saved immediately. 

An editor is typically used to edit or browse a document or input object. The input is identified using an **IEditorInput**. Modifications made in an editor part follow an **open-save-close lifecycle model**. 

This interface may be implemented directly. For convenience, a base implementation is defined in **WorkbenchPart**. 

The lifecycle of a workbench part is as follows: 
 
 * **When a part extension is created:** 
 	* instantiate the part
 	* create a part site
 	* call part.init(site)

 * **When a part becomes visible in the workbench:** 
	* add part to presentation by calling part.createPartControl(parent) to create actual widgets
	* fire partOpened event to all listeners

 * **When a part is activated or gets focus:** 
 	* call part.setFocus()
 	* fire partActivated event to all listeners
 * **When a part is closed:**
 	* if save is needed, do save; if it fails or is canceled return
	* if part is active, deactivate part
	* fire partClosed event to all listeners
	* remove part from presentation; part controls are disposed as part of the SWT widget tree 
	* call part.dispose()

After **createPartControl** has been called, the implementor may **safely reference the controls created**. When the part is closed these controls will be disposed as part of an SWT composite. This occurs before the IWorkbenchPart.dispose method is called. If there is a need to free SWT resources the part should define a dispose listener for its own control and free those resources from the dispose listener. If the part invokes any method on the disposed SWT controls after this point an SWTError will be thrown. 

The last method called on IWorkbenchPart is dispose. This signals the end of the part lifecycle. 

An important point to note about this lifecycle is that following a call to init, createPartControl may never be called. Thus in the dispose method, implementors must not assume controls were created. 

Workbench parts implement the IAdaptable interface; extensions are managed by the platform's adapter manager. 
See Also:
 * IViewPart
 * IEditorPart
