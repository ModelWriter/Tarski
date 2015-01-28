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

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class Activator extends AbstractUIPlugin
{

    // The plug-in ID
    /** The Constant PLUGIN_ID. */
    public static final String PLUGIN_ID = "org.topcased.doc2model.parser";

    // The shared instance
    /** The plugin. */
    private static Activator plugin;

    private final static int NO_LOG = 0;

    private final static int AT_LEAST_ONE_LOG = 1;

    private static int flag = NO_LOG;

    /**
     * The constructor.
     */
    public Activator()
    {
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
     * )
     */
    public void start(BundleContext context) throws Exception
    {
        super.start(context);
        plugin = this;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
     * )
     */
    public void stop(BundleContext context) throws Exception
    {
        plugin = null;
        super.stop(context);
    }

    public static boolean logOccurs()
    {
        return flag >= AT_LEAST_ONE_LOG;
    }

    /**
     * Returns the shared instance.
     * 
     * @return the shared instance
     */
    public static Activator getDefault()
    {
        return plugin;
    }

    /**
     * Log.
     * 
     * @param e the e
     */
    public static void log(final Exception e)
    {
        if (flag == NO_LOG)
        {
            flag = AT_LEAST_ONE_LOG;
        }
        Activator.log(e, IStatus.WARNING);
    }

    /**
     * Log.
     * 
     * @param e the exception
     * @param severity the severity
     */
    public static void log(Exception e, int severity)
    {
        IStatus status = new Status(severity, PLUGIN_ID, e.getMessage(), e);
        Activator.getDefault().getLog().log(status);
    }

    public static void reinitLogs()
    {
        flag = NO_LOG;
    }
}
