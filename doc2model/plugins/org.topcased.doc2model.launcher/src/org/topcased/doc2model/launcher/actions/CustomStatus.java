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
package org.topcased.doc2model.launcher.actions;

import org.eclipse.core.runtime.IStatus;
import org.topcased.doc2model.launcher.Activator;

/**
 * @deprecated
 */
public class CustomStatus implements IStatus
{
    private String message;

    private Throwable exception;

    private boolean cancel = false;

    public void setException(Throwable exception)
    {
        this.exception = exception;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public IStatus[] getChildren()
    {
        return null;
    }

    public int getCode()
    {
        return 0;
    }

    public Throwable getException()
    {
        return exception;
    }

    public String getMessage()
    {
        return message;
    }

    public String getPlugin()
    {
        return Activator.getDefault().toString();
    }

    public int getSeverity()
    {
        return 0;
    }

    public boolean isMultiStatus()
    {
        return false;
    }

    public boolean isOK()
    {
        return false;
    }

    public boolean matches(int severityMask)
    {
        return false;
    }

    public void setCancel(boolean cancel)
    {
        this.cancel = cancel;
    }

    public boolean isCancel()
    {
        return cancel;
    }

}
