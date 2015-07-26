**Package org.eclipse.ui Description**

Application programming interfaces for interaction with and extension of the Eclipse Platform User Interface. 

**Package Specification**

This package provides application programming interfaces for interaction with and extension of the Eclipse Platform User Interface. 

The **PlatformUI** class provides access to a single **workbench**.  A workbench is the root object for the UI and has one or more **workbench windows**.  Each workbench window has a collection of **workbench pages**, only one of which is active and visible to the end user.  Each workbench page has a collection of **workbench parts**.  A page's parts are arranged (tiled or stacked) for presentation on the screen.  Within a page and its parts the user can interact with and modify a model (typically resources in a workspace).   

There are two kinds of **workbench parts**: **views** and **editors**.  An editor is typically used to edit or browse a document or input object.  A view is typically used to navigate a hierarchy of information (like the workspace), open an editor, or display properties for the active editor. 

The platform creates a workbench when the workbench plug-in is activated.  Since this happens at most once during the life of the running platform, there is only one workbench instance. Due to its singular nature, it is commonly referred to as *the* workbench. 

Within a workbench the user will interact with many different resource types.  Because different tools are required for each, the workbench defines a number of extension points which allow for the integration of new tools.  There are extension points for views, editors, action sets, import wizards, export wizards, etc. 
 
