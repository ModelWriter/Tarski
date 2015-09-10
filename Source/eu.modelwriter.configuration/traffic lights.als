/*
All clafers: 21 | Abstract: 5 | Concrete: 14 | References: 2
Constraints: 3
Goals: 0
Global scope: 1..*
Can skip resolver: False
*/

pred show {}
run show for 1 but 2 c0_Library, 2 c0_List, 6 c0_NamedElement, 2 c0_Type, 2 c0_Web, 2 c0_contentTypes, 6 c0_name, 2 c0_ownedList, 2 c1_List

abstract sig c0_NamedElement
{ r_c0_name : one c0_name }

sig c0_name
{ ref : one Int }
{ one @r_c0_name.this }

abstract sig c0_Web extends c0_NamedElement
{ r_c0_ownedList : set c0_ownedList
, r_c0_ownedWeb : set c0_ownedWeb }

sig c0_ownedList extends c0_List
{}
{ one @r_c0_ownedList.this }

sig c0_ownedWeb extends c0_Web
{}
{ one @r_c0_ownedWeb.this }

abstract sig c0_List extends c0_NamedElement
{ r_c0_contentTypes : set c0_contentTypes
, r_c0_Type : one c0_Type }
{ all disj x, y : this.@r_c0_contentTypes | (x.@ref) != (y.@ref) }

sig c0_contentTypes
{ ref : one c0_ContentType }
{ one @r_c0_contentTypes.this }

sig c0_Type
{ r_c0_Library : lone c0_Library
, r_c1_List : lone c1_List }
{ one @r_c0_Type.this
  let children = (r_c0_Library + r_c1_List) | one children }

sig c0_Library
{}
{ one @r_c0_Library.this }

sig c1_List
{}
{ one @r_c1_List.this }

fact { #c0_ContentType = 0 }
abstract sig c0_ContentType extends c0_NamedElement
{ r_c0_isAbstract : lone c0_isAbstract
, r_c0_ownedField : set c0_ownedField }

sig c0_isAbstract
{ ref : one Int }
{ one @r_c0_isAbstract.this }

sig c0_ownedField extends c0_Field
{}
{ one @r_c0_ownedField.this }

fact { #c0_Field = 0 }
abstract sig c0_Field extends c0_NamedElement
{ r_c1_Type : one c1_Type }

sig c1_Type
{ r_c0_Number : lone c0_Number
, r_c0_Boolean : lone c0_Boolean
, r_c0_Text : lone c0_Text
, r_c0_Reference : lone c0_Reference }
{ one @r_c1_Type.this
  let children = (r_c0_Number + r_c0_Boolean + r_c0_Text + r_c0_Reference) | one children }

sig c0_Number
{}
{ one @r_c0_Number.this }

sig c0_Boolean
{}
{ one @r_c0_Boolean.this }

sig c0_Text
{}
{ one @r_c0_Text.this }

sig c0_Reference
{ r_c0_contentType : one c0_contentType }
{ one @r_c0_Reference.this
  all disj x, y : this.@r_c0_contentType | (x.@ref) != (y.@ref) }

sig c0_contentType
{ ref : one c0_ContentType }
{ one @r_c0_contentType.this }

one sig c0_ConferenceLibrary extends c0_Web
{}
{ (this.(@r_c0_name.@ref)) = 0 }

