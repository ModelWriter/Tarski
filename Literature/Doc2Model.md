
Doc2Model
=========
Doc2Model is responsible for parsing plain text and structured documents(includes styles, images etc.) to pruduce **EMF** models by applying some rules. 

###Purpose

The Purpose is to create a generic solution to parse different kinds of documents and transform  the business data into EMF model using XML parsing and EMF’s reflective capabilities.

###Scope

The documents file formats which will be managed by Doc2Model include:

•	Open source formats as docx, xlsx, odt, odf;
•	Common formats as csv;
•	And formats desired by the eclipse community.

In addition, Doc2Model provides an API to be able to extend it. Users can add custom parsers for specific tools. These Parsers could be contributed to Doc2model component if the license is compatible with EPL.

###What Doc2Model can do?
We expect Doc2Model to:

•	Identify metadata from a document
•	Consume associated data
•	Produce model from those data
