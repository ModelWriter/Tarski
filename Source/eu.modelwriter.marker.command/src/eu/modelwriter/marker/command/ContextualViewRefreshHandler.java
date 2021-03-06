/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd All rights reserved. This program and
 * the accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: Ferhat Erata - initial API and implementation H. Emre Kirmizi - initial API and
 * implementation Serhat Celik - initial API and implementation U. Anil Ozturk - initial API and
 * implementation
 *******************************************************************************/
package eu.modelwriter.marker.command;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import eu.modelwriter.marker.ui.internal.views.contextualview.ContextualView;

public class ContextualViewRefreshHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.contextualviewrefresh";

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    ContextualView.refreshTree();
    return true;
  }

}
