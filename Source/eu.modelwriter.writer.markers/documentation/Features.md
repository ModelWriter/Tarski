## [ModelWriter] Features - Product Owner Review Meeting

**Current Status of the ModelWriter Marker and Mapping Functionality**  
1. Text (which means the marking process on a textual concrete syntax, mostly starts with one of the `ITextSelection`)  
    + User shall be able to mark any kind of textual documents on Eclipse Editor.  
      + User shall be able to mark text fragments on a Markdown, Wikitext file (Eclipse Wiki Editor).  
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
    + User should be able to see the start and end char positions of markers shift while editing on the text editor.  
      + Offset and Length of markers should be updated while editing on the text editor.  
    + User shall be able to delete any marker based on a valid text selection on the editor.  
    + User shall be able to mark a text fragment by the 'Mark All' command to indicate that all text fragments with the same syntax should be searched and marked as well.  
    + User shall be able to delete a marker which has been already marked by the 'Mark All' command by menas of the 'Delete All' command to indicate that all the related markers should be also deleted.  
2. Model  (which means the marking process on a structured concrete syntax, mostly starts with one of the `ITreeSelection` or `ISturucturedSelection`)  
    + User shall be able to mark an `ENamedElement` on an Editor based on `EcoreEditor`  
      + User shall be able to mark a EMF model element on EcoreEditor and Reflective Editor.  
        + `plugin: org.eclipse.emf.ecore.editor`  
        + `editor: org.eclipse.emf.ecore.presentation.EcoreEditor`  
      + User shall be able to mark a EMF model element on Generic EMF Form Editor  
        + `plugin: org.eclipse.emf.generic.editor`  
        + `editor: org.eclipse.emf.editor.EEditor`  
      + User shall be able to mark a EMF model element on Sample Reflective Editor  
    + Once an instance of EMF model is marked on the `EcoreEditor`, The offset and length of the corresponding XMI statement should also be marked.  
    + User shall be able to delete an `ENamedElement` on the `EcoreEditor`  
      + Once an instance of `EClass` is deleted, Markers on its EStructuralFeatures should be deleted.  
      + Once an instance of `EAttribute` is deleted, its marker should also be deleted.  
      + Once an instance of `EReference` is deleted, its marker should also be deleted.  
      + Once an instance of `EPackage` is deleted, all `Subpackages`, `EClassifiers` and `EStructuralFeatures` of those `EPackage` should be deleted recursively.  
    + User shall be able to mark Reqif10 model elements such as `SpecObject` and `SpecHierarchy`.
      + `plugin: org.eclipse.rmf.reqif10.pror.editor`  
      + `editor: org.eclipse.rmf.reqif10.pror.editor.presentation.SpecificationEditor`  
3. Model <-> Text  
    + Show mapping between arbitrary model and text markings  
    + Show the filter on the project explorer view on the mapping wizard  



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
