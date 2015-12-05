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
package eu.modelwriter.marker.ui.internal.views.mappingview;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
import org.eclipse.core.resources.IMarker;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.IHandlerService;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.ViewPart;

import eu.modelwriter.marker.internal.MarkerFactory;

public class SourceView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.sourceview";
  private static TableViewer sourceViewer;

  public static Object getViewerInput() {
    return SourceView.sourceViewer.getInput();
  }

  public static void refresh() {
    SourceView.sourceViewer.refresh();
  }

  public static void setColumns(final Object element) {
    SourceView.sourceViewer.setInput(element);
  }

  @Override
  public void createPartControl(final Composite parent) {
    SourceView.sourceViewer =
        new TableViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
    SourceView.sourceViewer.getTable().setHeaderVisible(true);
    SourceView.sourceViewer.setContentProvider(ArrayContentProvider.getInstance());
    new ViewIDColumn().addColumnTo(SourceView.sourceViewer);
    new ViewTextColumn().addColumnTo(SourceView.sourceViewer);
    new ViewOffsetColumn().addColumnTo(SourceView.sourceViewer);
    new ViewLengthColumn().addColumnTo(SourceView.sourceViewer);
    new ViewLineNumberColumn().addColumnTo(SourceView.sourceViewer);
    new ViewPathColumn().addColumnTo(SourceView.sourceViewer);

    SourceView.sourceViewer.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(final DoubleClickEvent event) {
        final IStructuredSelection selection = (IStructuredSelection) event.getSelection();

        if ((IMarker) selection.getFirstElement() == null) {
          final IHandlerService handlerService =
              PlatformUI.getWorkbench().getService(IHandlerService.class);
          try {
            handlerService.executeCommand(MarkerFactory.SOURCEVIEW_REF, null);
          } catch (ExecutionException | NotDefinedException | NotEnabledException
              | NotHandledException e) {
            e.printStackTrace();
          }
          return;
        }
        try {
          IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
              (IMarker) selection.getFirstElement());
        } catch (final PartInitException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void setFocus() {
    SourceView.sourceViewer.getControl().setFocus();
  }
}
