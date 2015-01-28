/*****************************************************************************
 * Copyright (c) 2008 Atos Origin.
 * 
 * 
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License v1.0 which
 * accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors: Tristan Faure (Atos Origin) tristan.faure@atosorigin.com -
 * Initial API and implementation
 * 
 *****************************************************************************/
package org.topcased.doc2model.parser;

/**
 * Interface to notify parsing progression
 * 
 * @author tristan.faure@atosorigin.com
 */
public interface ProgressionObserver
{
    /**
     * This method notify the maximum number of elements
     * 
     * @param max the max
     */
    void setMax(int max);

    /**
     * This method notify the process progression
     * 
     * @param i the i
     */
    void worked(int i);

    /**
     * isCanceled
     * 
     * @return true, if the process is canceled
     */
    boolean isCanceled();

    /**
     * warningOrErrorsOccurs
     * 
     * this method is called when some elements have been logged
     */
    void warningOrErrorsOccurs();

    /**
     * notifyNoElementsFounded
     * 
     * this method is called when the generated model is empty
     */
    void notifyNoElementsFounded();
}
