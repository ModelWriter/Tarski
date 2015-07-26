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

+ **eu.modelwriter.marker.model** (ITreeSelection,IStructuredSelection)  
	+ eu.modelwriter.marker.model  
	+ eu.modelwriter.marker.model.decorators

+ **eu.modelwriter.marker**  
	+ eu.modelwriter.marker  
		  MarkerActivator.java
	+ eu.modelwriter.marker.xml
	+ eu.modelwriter.marker

+ **eu.modelwriter.marker.action**
	+ eu.modelwriter.marker.action

+ **eu.modelwriter.marker.ui**
  + eu.modelwriter.marker.ui.internal.views.master
  + eu.modelwriter.marker.ui.views.master
	+ eu.modelwriter.marker.ui.internal.views.target
	+ eu.modelwriter.marker.ui.internal.views.source
	+ eu.modelwriter.marker.ui.internal.views.properties
  + eu.modelwriter.marker.ui.internal.perspective

+ **eu.modelwriter.marker.ui.wizards**
	+ eu.modelwriter.marker.ui.wizards.internal

+ **eu.modelwriter.marker.text** (ITextSelection, IMarkSelection)  
	+ eu.modelwriter.marker.text  
	+ eu.modelwriter.marker.text.annotations
	+ eu.modelwriter.marker.text.hyperlinkdetectors  

+ **eu.modelwriter.texteditor

========================================================================
