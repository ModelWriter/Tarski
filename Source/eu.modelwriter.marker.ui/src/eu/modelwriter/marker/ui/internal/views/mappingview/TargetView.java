/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D Ltd
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Ferhat Erata - initial API and implementation
 *     H. Emre Kirmizi - initial API and implementation
 *     Serhat Celik - initial API and implementation
 *     U. Anil Ozturk - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.marker.ui.internal.views.mappingview;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.NotEnabledException;
import org.eclipse.core.commands.NotHandledException;
import org.eclipse.core.commands.common.NotDefinedException;
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

import eu.modelwriter.marker.internal.MarkElement;
import eu.modelwriter.marker.internal.MarkerFactory;

public class TargetView extends ViewPart {

  public static final String ID = "eu.modelwriter.marker.ui.views.targetview";
  private static TableViewer targetViewer;

  @Override
  public void dispose() {
    super.dispose();
  }

  @Override
  public void createPartControl(Composite parent) {
    targetViewer = new TableViewer(parent, SWT.FULL_SELECTION | SWT.H_SCROLL | SWT.V_SCROLL);
    targetViewer.getTable().setHeaderVisible(true);
    targetViewer.setContentProvider(ArrayContentProvider.getInstance());
    new ViewIDColumn().addColumnTo(targetViewer);
    new ViewTextColumn().addColumnTo(targetViewer);
    new ViewOffsetColumn().addColumnTo(targetViewer);
    new ViewLengthColumn().addColumnTo(targetViewer);
    new ViewLineNumberColumn().addColumnTo(targetViewer);
    new ViewPathColumn().addColumnTo(targetViewer);

    targetViewer.addDoubleClickListener(new IDoubleClickListener() {
      @Override
      public void doubleClick(DoubleClickEvent event) {
        IStructuredSelection selection = (IStructuredSelection) event.getSelection();
        if (((MarkElement) selection.getFirstElement()).getiMarker() == null) {
          IHandlerService handlerService =
              PlatformUI.getWorkbench().getService(IHandlerService.class);
          try {
            handlerService.executeCommand(MarkerFactory.TARGETVIEW_REF, null);
          } catch (ExecutionException | NotDefinedException | NotEnabledException
              | NotHandledException e) {
            e.printStackTrace();
          }
          return;
        }

        try {
          IDE.openEditor(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage(),
              ((MarkElement) selection.getFirstElement()).getiMarker());
        } catch (PartInitException e) {
          e.printStackTrace();
        }
      }
    });
  }

  @Override
  public void setFocus() {
    targetViewer.getControl().setFocus();
  }

  public static void setColumns(Object element) {
    targetViewer.setInput(element);
  }

  public static void refresh() {
    targetViewer.refresh();
  }

  public static Object getViewerInput() {
    return targetViewer.getInput();
  }
}
