==**org.eclipse.ui.IWorkbenchWindow**===============================

A workbench window is a top level window in a workbench. 
Visually, a workbench window has **a menubar, a toolbar, a status bar, and a main area for displaying a single page consisting of a collection of views and editors**. 

Each workbench window has a collection of 0 or more pages; the active page is the one that is being presented to the end user; **at most one page is active in a window at a time.** 

The workbench window supports a few services by default. If these services are used to allocate resources, it is important to remember to clean up those resources after you are done with them. Otherwise, the resources will exist until the workbench window is closed. The supported services are: 

 * ICommandService
 * IContextService
 * IHandlerService
 * IBindingService. Resources allocated through this service will not be cleaned up until the workbench shuts down.

This interface is not intended to be implemented by clients.