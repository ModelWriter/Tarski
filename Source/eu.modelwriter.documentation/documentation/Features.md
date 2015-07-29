## [ModelWriter] Features - Product Owner Review Meeting

**Current Status of the ModelWriter Marker and Mapping Functionality**  
1. **Text** (which means the marking process on a textual concrete syntax, mostly starts with `ITextSelection`)  
    + User shall be able to mark any kind of textual documents on Eclipse Editor.  
      + User shall be able to mark text fragments on a Markdown, Wikitext.. file (Eclipse Wiki Editor).
        + `plugin: org.eclipse.mylyn.wikitext.ui`
        + `editor: org.eclipse.mylyn.internal.wikitext.ui.editor.MarkupEditor`
      + User shall be able to mark text fragments on a Java file (Eclipse JDT Java Editor).
        + `plugin: org.eclipse.jdt.ui`
        + `editor: org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor`
      + User shall be able to mark text fragments on an XML file (Eclipse XML Editor).
        + `plugin: org.eclipse.wst.xml.ui`
        + `editor: org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart`
      + User shall be able to mark text fragments on a Plain text file (Eclipse Text Editor).
        + `plugin: org.eclipse.ui.editors`  
        + `editor: org.eclipse.ui.editors.text.TextEditor`
      + User shall be able to should mark text fragments on a Textual DSL (Eclipse Xtext Editor).
        + `editor: org.eclipse.xtext.xbase.ui.editor.XbaseEditor`
    + User shall be able to see the start and end char positions of markers shifting while editing on the text editor.
      + Offset and Length of markers should be updated while editing on the text editor.
    + The system shall indicate text fragments or a model elements which are already linked by means of a kind of visual indicator.
    + User shall be able to delete any marker based on a valid text selection on the editor.
      + Precondition: the text should be marked before deletion.
    + User shall be able to mark a text fragment by the 'Mark All' command to indicate that all text fragments with the same syntax should be searched and marked as well as different representations of single entity.
      + Although the system should assign unique IDs to all markers, another group ID should be also assigned.
    + User shall be able to delete a marker which has been already marked by the 'Mark All' command by means of the 'Delete All' command to indicate that all the related markers should be also deleted.
    + s
2. **Model** (which means the marking process on a structured concrete syntax, mostly starts with one of the `ITreeSelection` or `ISturucturedSelection`)
    + User shall be able to mark an element which inherits `ENamedElement` on an Eclipse Ecore Editor.
      + User shall be able to mark an EMF model element on EcoreEditor/EMF Reflective Editor.
        + `plugin: org.eclipse.emf.ecore.editor`
        + `editor: org.eclipse.emf.ecore.presentation.EcoreEditor`
      + User shall be able to mark a EMF model element on Generic EMF Form Editor
        + `plugin: org.eclipse.emf.generic.editor`
        + `editor: org.eclipse.emf.editor.EEditor`
    + User shall be able to mark an element which inherits `NamedElement` on an Eclipse UML Editor.
      + User shall be able to mark a UML model element on the tree-based UML2 editor of Eclipse.
        + `plugin: org.eclipse.uml2.uml.editor`
        + `editor: org.eclipse.uml2.uml.editor.presentation.UMLEditor`
          + `selection: org.eclipse.uml2.uml.NamedElement`
      + User shall be able to mark a UML model element on the free-form UML editor of Eclipse.
        + `plugin: org.eclipse.papyrus.editor`
        + `editor: org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor`
      + User shall be able to mark a UML model element on the free form Sirius editor of Eclipse.  
        + `plugin: org.eclipse.sirius.diagram.ui.ext`
         + `editor: org.eclipse.sirius.diagram.ui.tools.internal.editor.DDiagramEditorImpl`
          + `selection: org.eclipse.emf.ecoretools.design.ui.parts.DNodeListEditPartWithAlpha`
          + `selection: org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart`
          + `selection: org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListEditPart`
          + `selection: org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart`
    + User shall be able to mark OMG ReqIF model elements such as `SpecObject` and `SpecHierarchy`.
        + `plugin: org.eclipse.rmf.reqif10.pror.editor` (RMF is still in incubation phase)
        + `editor: org.eclipse.rmf.reqif10.pror.editor.presentation.SpecificationEditor`
         + `selection: org.eclipse.rmf.reqif10.Specification`
         + `selection: org.eclipse.rmf.reqif10.SpecObject`
         + `selection: org.eclipse.rmf.reqif10.SpecHierarchy`
    + User shall be able to mark OMG BPMN2.x model elements such as `` and ``.
        + `plugin:? `
        + `editor: ?`
         + `selection: ?`
    + Once an instance of EMF model is marked on the `EcoreEditor`, The offset and length of the corresponding XMI statement should be also marked.
    + User shall be able to delete an `ENamedElement` on the `EcoreEditor`.
      + Once an instance of `EClass` is deleted, Markers on its EStructuralFeatures should be deleted.
      + Once an instance of `EAttribute` is deleted, its marker should also be deleted.
      + Once an instance of `EReference` is deleted, its marker should also be deleted.
      + Once an instance of `EPackage` is deleted, all `Subpackages`, `EClassifiers` and `EStructuralFeatures` of those `EPackage` should be deleted recursively.

3. **Model <-> Text**
  + Show mapping between arbitrary model and text markings
  + Show the filter on the project explorer view on the mapping wizard

4. **Views (UI parts)**
  + MW Markers Master View...
  + Source and Target Views

*** Undo
*** Marker persistency

+ org.eclipse.pde.ui
  + org.eclipse.pde.internal.ui.editor.plugin.ManifestEditor

+ org.eclipse.jdt.ui
  + org.eclipse.jdt.internal.ui.javaeditor.CompilationUnitEditor

+ org.eclipse.mylyn.wikitext.ui
  + org.eclipse.mylyn.internal.wikitext.ui.editor.MarkupEditor

+ org.eclipse.wst.xml.ui
  + org.eclipse.wst.xml.ui.internal.tabletree.XMLMultiPageEditorPart

+ org.eclipse.ui.editors
  + org.eclipse.ui.editors.text.TextEditor

+ org.eclipse.emf.ecore.editor
  + org.eclipse.emf.ecore.presentation.EcoreEditor

+ org.eclipse.emf.generic.editor
 + org.eclipse.emf.editor.EEditor

+ org.eclipse.papyrus.editor
 + org.eclipse.papyrus.editor.PapyrusMultiDiagramEditor

+ org.eclipse.uml2.uml.editor
 + org.eclipse.uml2.uml.editor.presentation.UMLEditor

+ org.eclipse.sirius.table.ui.ext
 + org.eclipse.sirius.table.ui.tools.internal.editor.DTableEditionEditor

+ org.eclipse.sirius.diagram.ui.ext
 + org.eclipse.sirius.diagram.ui.tools.internal.editor.DDiagramEditorImpl
  + org.eclipse.emf.ecoretools.design.ui.parts.DNodeListEditPartWithAlpha
  + org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeContainerEditPart
  + org.eclipse.sirius.diagram.ui.internal.edit.parts.DNodeListEditPart
  + org.eclipse.sirius.diagram.ui.internal.edit.parts.DEdgeEditPart


org.eclipse.graphiti.ui.internal.parts.IContainerShapeEditPart
org.eclipse.graphiti.ui.internal.parts.FreeFormConnectionEditPart
org.eclipse.bpmn2.modeler.ui.views.outline.PoolTreeEditPart
org.eclipse.bpmn2.modeler.ui.views.outline.FlowElementTreeEditPart

org.eclipse.ui.views.contentoutline.ContentOutline

org.eclipse.sirius.diagram.ui.tools.internal.editor.DiagramOutlinePage

ŞUBAT, MART, NİSAN, MAYIS, HAZIRAN, TEMMUZ
Kira: 7357.20
Elektirik: 18 TL
