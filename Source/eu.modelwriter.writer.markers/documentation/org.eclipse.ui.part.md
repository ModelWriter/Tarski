Classes for the creation of workbench parts that integrate with the Eclipse Platform User Interface. 

**Package Specification**
A workbench part is a visual component within a **workbench page**.  There are two types: **view** and **editor**, as defined by **IViewPart** and **IEditorPart**.   An editor is typically used to edit or browse a document or input object.  A view is typically used to navigate a hierarchy of information (like the workspace), open an editor, or display properties for the active editor.  This package provides a base implementation for the definition of views and editors. 
  