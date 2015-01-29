head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.19.50;	author tfaure;	state Exp;
branches;
next	;
commitid	66574b8d8ee24567;


desc
@@


1.1
log
@first commit for doc2model api
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.doc2model;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Create Element Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEClassName <em>EClass Name</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEpackage <em>Epackage</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getNewElement <em>New Element</em>}</li>
 *   <li>{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getContainer <em>Container</em>}</li>
 * </ul>
 * </p>
 *
 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCreateElementAction()
 * @@model
 * @@generated
 */
public interface CreateElementAction extends Action {
	/**
	 * Returns the value of the '<em><b>EClass Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>EClass Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>EClass Name</em>' attribute.
	 * @@see #setEClassName(String)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCreateElementAction_EClassName()
	 * @@model
	 * @@generated
	 */
	String getEClassName();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEClassName <em>EClass Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>EClass Name</em>' attribute.
	 * @@see #getEClassName()
	 * @@generated
	 */
	void setEClassName(String value);

	/**
	 * Returns the value of the '<em><b>Epackage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Epackage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Epackage</em>' reference.
	 * @@see #setEpackage(EPackageReference)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCreateElementAction_Epackage()
	 * @@model
	 * @@generated
	 */
	EPackageReference getEpackage();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getEpackage <em>Epackage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Epackage</em>' reference.
	 * @@see #getEpackage()
	 * @@generated
	 */
	void setEpackage(EPackageReference value);

	/**
	 * Returns the value of the '<em><b>New Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>New Element</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>New Element</em>' reference.
	 * @@see #setNewElement(ActionResultObject)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCreateElementAction_NewElement()
	 * @@model
	 * @@generated
	 */
	ActionResultObject getNewElement();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getNewElement <em>New Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>New Element</em>' reference.
	 * @@see #getNewElement()
	 * @@generated
	 */
	void setNewElement(ActionResultObject value);

	/**
	 * Returns the value of the '<em><b>Container</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Container</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @@return the value of the '<em>Container</em>' reference.
	 * @@see #setContainer(Value)
	 * @@see org.eclipse.emf.doc2model.doc2model.Doc2modelPackage#getCreateElementAction_Container()
	 * @@model
	 * @@generated
	 */
	Value getContainer();

	/**
	 * Sets the value of the '{@@link org.eclipse.emf.doc2model.doc2model.CreateElementAction#getContainer <em>Container</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @@param value the new value of the '<em>Container</em>' reference.
	 * @@see #getContainer()
	 * @@generated
	 */
	void setContainer(Value value);

} // CreateElementAction
@
