=**Inside the Workbench: A guide to the workbench internals**======  
https://www.eclipse.org/articles/Article-UI-Workbench/workbench.html
https://wiki.eclipse.org/Eclipse_Plug-in_Development_FAQ

=**Editors**=======================================================  
org.eclipse.emf.ecore.presentation.EcoreEditor  
org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart  
org.eclipse.mylyn.internal.wikitext.ui.editor.MarkupEditor  
org.eclipse.emf.editor.EEditor  
=**Selections**====================================================    
org.eclipse.jface.viewers.TreeSelection  
org.eclipse.jface.viewers.ITreeSelection  
--------------------------------------------  
org.eclipse.wst.sse.ui.StructuredTextEditor$StructuredSelectionProvider$StructuredTextSelection  
org.eclipse.jface.viewers.IStructuredSelection  
--------------------------------------------

=**Eclipse Workbench: Selection Service**===========================  
https://eclipse.org/articles/Article-WorkbenchSelections/article.html
A list of objects or a piece of text can be selected
====**Interfaces**==================================================  
IStructuredSelection
ITextSelection
IMarkSelection
ITreeSelection
====**Default implementations for these interfaces**================  
org.eclipse.jface.viewers.StructuredSelection
org.eclipse.jface.viewers.TreeSelection
org.eclipse.jface.text.TextSelection
org.eclipse.jface.text.MarkSelection
====================================================================  
All JFace viewers are so called selection providers. A selection provider implements the interface ISelectionProvider:

**Viewer**					**Selection Type**
ComboViewer					IStructuredSelection
ListViewer					IStructuredSelection
TreeViewer					IStructuredSelection, ITreeSelection
 +- CheckboxTreeViewer		IStructuredSelection, ITreeSelection
TableViewer					IStructuredSelection
 +- CheckboxTableViewer		IStructuredSelection
TextViewer					ITextSelection, IMarkSelection
 +- SourceViewer			ITextSelection, IMarkSelection
     +- ProjectionViewer	ITextSelection, IMarkSelection

==**Markers**=========================================================  
org.eclipse.ui.internal.views.markers.AllMarkersView


==**Namespace Hierarchy**=============================================  

+ **eu.modelwriter.model** (ITreeSelection,IStructuredSelection)  
	+ eu.modelwriter.model  
		...
	+ eu.modelwriter.model.annotations  


+ **eu.modelwriter.marker**  
	+ eu.modelwriter.markers  
		MarkerActivator.java  
	+ eu.modelwriter.writer.markers.views.internal  
		...
	+ eu.modelwriter.writer.markers.wizards.internal  
		...

+ **eu.modelwriter.text** (ITextSelection, IMarkSelection)  
	+ eu.modelwriter.text  
	+ eu.modelwriter.text.annotations   
	+ eu.modelwriter.writer.markers.hyperlinkdetectors  
	
	
========================================================================             
	