Hello all, 
@ModelWriter/consortium

This issue is about defining all the development good practices we need to apply on all the MW project plug-ins.

Please feel free to discuss any related detail here.
Regards,
Marwa


## WP1 - Industrial Use Cases and Requirements (AIRBUS)

![WP1 - Cost & Efforts](figures/wp1.png)

### T1.1 - Evaluation Methods & Tools [UNIT + KOCSISTEM + AIRBUS + OBEO + HISBIM + MANTIS]


-------------------------------------------------------
**GOOD PRACTICES:**
-------------------------------------------------------
* In the workspace:
 * Please set the right files encoding : to do so go to **Window -> Preferences -> Workspace** and choose the **UTF-8** encoding instead of the Cp1252 encoding as a default one
 * Please add facilities actions to format well the content of your files: to do so go to **Window -> Preferences -> Java -> Editor -> Save Actions** and check the box to **format all lines** of the source code and the **Organize Imports** box.

This will prevent some merge and rebase problems for other partners working on the same code.

* Github process to keep the history clean and easy to read:
  * Please configure correctly your git to display correctly your name/email commits
  * Please use the command: **git pull --rebase** instead of **merging**. This will keep a linear readable history.
  * For all work in progress please make a branch based on the current master branch and named **wip/< name of your current task >**. Then, when the task progress is finished please rebase on the master branch  ensure that other partners are not working on the branch before deleting it from the repository.
  * For each finished deliverable task please create a tag using the **deliverable code**, **name** and its **milestone** as a name (e.g
 **D6.1.1-SoftwarePrototypeCoreModelWriter-M6**)

**To Be Continued** during the project lifecycle...
