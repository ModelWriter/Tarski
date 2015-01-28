Mylyn Intent
===========
Main purpose of Intent is to **keep your documentation synchronized** with any concrete development artifact (whether it's Java code, Models, dependencies between plugins, a code example on the Internet).

Intent does promise to provide:
> - Tools for creating documentation **mixing a formal and non-formal syntax**
> - Tools for collaborating on top of such documentations
> - Tools for editing, validating the documentation
> - Tools for synchronizing the documentation regarding the development artifacts
> - Tools for **automatically checking** constraints and guidelines.
 
 Intent does **NOT** promise to provide:
 > - Tooling and framework to create domain specific languages
 > - Specific support for documentation formats and syntaxes (see wikitext).
 > - Reusable UI components for documentation or rich text editing.
 > - Documentation file format interoperability

###A synchronization framework
- it compiles the document into complete models upon which constraints and predicates can be checked ;
- it synchronizes these models with the real development artifacts providing the user two possibilities : updating the documentation or updating the artifact itself **manually**;
- it has the ability to be extended to provide better integration with other Eclipse projects, enabling for instance consistency check between PDE artifacts and the documentation

This synchronization mechanism is totally extensible : you will be able to synchronize any kind of artifact with the documentation, as long as the corresponding **Synchronization Bridge** has been written.

###Output
Documents are exported as HTML format.

###What can we do with Intent?
1. When you update the requirements, Intent detects synchronization issues and when you update your code to reflect those changes documentation and code are now up-to-date.
 
2. You can also update your code, and then rely on Intent to determine which parts of the documentation have to be updated. In that case you can decide to update the document whenever you want.
