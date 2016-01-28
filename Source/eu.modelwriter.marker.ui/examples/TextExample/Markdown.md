#Customer Requirements Specification

##UC-1 Create a new SpecObject

Note that the Specification Editor is the main interface for users. Therefore, creating SpecObjects in this editor is the main success scenario.
	
###Precondition

ReqIF model exists and is open.
	
###Main Success Scenario

We assume that a Specification exists and is open (not required for alternative scenario)

Open a row's context menu (or in the empty editor space)
	
Select the Child or Sibling submenu.	

Select the desired Spec Object Type (or none) from the submenu.	

This results in a new SpecHierarchy being created that is linked to a newly created SpecObject with the correct type.	

###Alternative 1: Create in Outline

The same workflow works for elements that are shown underneath "Specifications" in the outilne.	

It is also possible to create children of the "SpecObjects" folder in the outline, but in this case, no SpecHirarchy will be created.
	
###Alternative 2: Keyboard Shortcut

The keyboard shortcut Ctrl-Enter will create a SpecHierarchy sibling to the currently selected element and immediately go into edit mode in the currently selected column.	

##UC-2 Edit SpecObject

###Precondition

A ReqIF model exists, is open and at least one SpecObject exisits.	

###Main Success Scenario

We assume that a Specification exists and is open (not required for alternative scenario)
	
Double click on the cell in the Specification Editor to be edited.
	
Alternatively, hit enter or space in that cell	

In both cases, the double-clicked / selected cell will switch to edit mode.	

Note that some cells may not be editable, in which case nothing will happen.	

###Alternative 1: Edit in Properties View

A selected element (no matter whether in Specification Editor or Outline or elsewhere) will be shown in the Properties View, where editing of all values is possible.
	
##UC-3 Delete SpecObject

###Precondition

A ReqIF model exists, is open and at least one SpecObject exists.	

###Main Success Scenario

If an element is deleted from the specification (so essentially a SpecHierarchy), and no references to the associated SpecObject exist, then that SpecObject should be deleted as well. Otherwise, only the SpecHierarchy will be removed.	

###Alternative 1: Delete in SpecObjects folder in Outline

If the SpecObject is deleted from the SpecObjects folder in the ouline, it will be removed, no matter what. This may result in SpecHierarchies that are not referencing any SpecObjects.	