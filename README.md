Work Package 3
===
**Work Package 3 - Model to/from Knowledge Base (UNIT)**

[`Product Backlog of WP7`](https://waffle.io/ModelWriter/WP3)

The product backlog itself is implemented in the [`issue tracker`](https://github.com/modelwriter/wp3/issues) of this repository

Objectives
---

The primary objective of this WP is to provide the `synchronization mechanism` of the ModelWriter platform that will keep the `user-visible models` consistent with the `KB-stored models` and vice versa. This work package addresses all problems related to the "model-to-model transformations" in ModelWriter.

* By `user-visible models` is meant those models that have been explicitly created by a Technical Author, using e.g. a spreadsheet, a kind of UML diagram, a block diagram, a mind map, etc. or any modelling tool (part of the “Model” side of ModelWriter) he has found the most appropriate for authoring his technical information. 
* By `KB-stored model` is meant a part of the Knowledge Base devoted to storing pieces of related information, disregarding whether it is represented in user-visible models, in natural-language documents, or in both.

This mechanism will be based on `model-to-model (M2M) transformations` of two complementary categories:

* WP3.1, for transforming a `user-visible model` to a KB-stored model (this "mirrors" WP2.1).
* WP3.2, for transforming a `KB-stored model` into a user-visible model (this "mirrors" WP2.2).

Expected Results
---

An Eclipse-based M2M Transformation Framework, extensible so as to accommodate an increasing number of types of (user-visible) models. This will consist of the following main envisioned plug-in components:

* `Transformation Manager`: provides the infrastructure to register and launch transformations.
* `Configuration Manager`: for personalizing the behaviour of the framework to meet the needs of a specific standard / organization / project / individual.
* `Traceability Manage`: keeps links between elements of user-visible models and elements of the KB.
* `Synchronization Manager`: triggering transformations when synchronization is needed.

Approach for the Work Package
---

The main goal of this WP is to develop a M2M Transformation Framework that supports the synchronization mechanisms for the ModelWriter tool.

These mechanisms will be based on a requirements synchronization framework that can be extended to support different requirements models (based on both textual and/or visual notations). The framework is made up of three main components: 

 1.	A meta-modelling infrastructure, 
 2.	A DSL for model transformation specifications, and 
 3.	A model synchronization API. 

*final version*
