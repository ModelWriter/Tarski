/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
/**
 */
package useCase.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import useCase.Activity;
import useCase.Actor;
import useCase.ConditionalFlow;
import useCase.Documentation;
import useCase.EndEvent;
import useCase.Expression;
import useCase.InclusiveGateway;
import useCase.Interest;
import useCase.IntermediateCatchEvent;
import useCase.IntermediateThrowEvent;
import useCase.ParallelGateway;
import useCase.SequenceFlow;
import useCase.Specification;
import useCase.StartEvent;
import useCase.UseCase;
import useCase.UseCaseFactory;
import useCase.UseCasePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class UseCaseFactoryImpl extends EFactoryImpl implements UseCaseFactory {
  /**
   * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public static UseCaseFactory init() {
    try {
      UseCaseFactory theUseCaseFactory =
          (UseCaseFactory) EPackage.Registry.INSTANCE.getEFactory(UseCasePackage.eNS_URI);
      if (theUseCaseFactory != null) {
        return theUseCaseFactory;
      }
    } catch (Exception exception) {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new UseCaseFactoryImpl();
  }

  /**
   * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public UseCaseFactoryImpl() {
    super();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  @Override
  public EObject create(EClass eClass) {
    switch (eClass.getClassifierID()) {
      case UseCasePackage.SPECIFICATION:
        return createSpecification();
      case UseCasePackage.USE_CASE:
        return createUseCase();
      case UseCasePackage.ACTOR:
        return createActor();
      case UseCasePackage.INTEREST:
        return createInterest();
      case UseCasePackage.EXPRESSION:
        return createExpression();
      case UseCasePackage.CONDITIONAL_FLOW:
        return createConditionalFlow();
      case UseCasePackage.ACTIVITY:
        return createActivity();
      case UseCasePackage.PROCESS:
        return createProcess();
      case UseCasePackage.DOCUMENTATION:
        return createDocumentation();
      case UseCasePackage.START_EVENT:
        return createStartEvent();
      case UseCasePackage.END_EVENT:
        return createEndEvent();
      case UseCasePackage.INTERMEDIATE_CATCH_EVENT:
        return createIntermediateCatchEvent();
      case UseCasePackage.INTERMEDIATE_THROW_EVENT:
        return createIntermediateThrowEvent();
      case UseCasePackage.SEQUENCE_FLOW:
        return createSequenceFlow();
      case UseCasePackage.INCLUSIVE_GATEWAY:
        return createInclusiveGateway();
      case UseCasePackage.PARALLEL_GATEWAY:
        return createParallelGateway();
      default:
        throw new IllegalArgumentException(
            "The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Specification createSpecification() {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public UseCase createUseCase() {
    UseCaseImpl useCase = new UseCaseImpl();
    return useCase;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Actor createActor() {
    ActorImpl actor = new ActorImpl();
    return actor;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Interest createInterest() {
    InterestImpl Interest = new InterestImpl();
    return Interest;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Expression createExpression() {
    ExpressionImpl expression = new ExpressionImpl();
    return expression;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ConditionalFlow createConditionalFlow() {
    ConditionalFlowImpl conditionalFlow = new ConditionalFlowImpl();
    return conditionalFlow;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Activity createActivity() {
    ActivityImpl activity = new ActivityImpl();
    return activity;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public useCase.Process createProcess() {
    ProcessImpl process = new ProcessImpl();
    return process;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public Documentation createDocumentation() {
    DocumentationImpl documentation = new DocumentationImpl();
    return documentation;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public StartEvent createStartEvent() {
    StartEventImpl startEvent = new StartEventImpl();
    return startEvent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public EndEvent createEndEvent() {
    EndEventImpl endEvent = new EndEventImpl();
    return endEvent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IntermediateCatchEvent createIntermediateCatchEvent() {
    IntermediateCatchEventImpl IntermediateCatchEvent = new IntermediateCatchEventImpl();
    return IntermediateCatchEvent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public IntermediateThrowEvent createIntermediateThrowEvent() {
    IntermediateThrowEventImpl IntermediateThrowEvent = new IntermediateThrowEventImpl();
    return IntermediateThrowEvent;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public SequenceFlow createSequenceFlow() {
    SequenceFlowImpl sequenceFlow = new SequenceFlowImpl();
    return sequenceFlow;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public InclusiveGateway createInclusiveGateway() {
    InclusiveGatewayImpl InclusiveGateway = new InclusiveGatewayImpl();
    return InclusiveGateway;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public ParallelGateway createParallelGateway() {
    ParallelGatewayImpl parallelGateway = new ParallelGatewayImpl();
    return parallelGateway;
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @generated
   */
  public UseCasePackage getUseCasePackage() {
    return (UseCasePackage) getEPackage();
  }

  /**
   * <!-- begin-user-doc --> <!-- end-user-doc -->
   * 
   * @deprecated
   * @generated
   */
  @Deprecated
  public static UseCasePackage getPackage() {
    return UseCasePackage.eINSTANCE;
  }

} // UseCaseFactoryImpl
