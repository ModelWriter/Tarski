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

import java.util.Map;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.commands.ICommandService;
import org.eclipse.ui.commands.IElementUpdater;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.menus.UIElement;
import org.eclipse.ui.texteditor.AnnotationPreference;

import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerVisibilityHandler extends AbstractHandler implements IElementUpdater {

  public static String COMMAND_ID = "eu.modelwriter.marker.command.markervisibility";

  private final AnnotationPreference prefMapping = EditorsUI.getAnnotationPreferenceLookup()
      .getAnnotationPreference(AnnotationFactory.ANNOTATION_MAPPING);

  private final AnnotationPreference prefMarking = EditorsUI.getAnnotationPreferenceLookup()
      .getAnnotationPreference(AnnotationFactory.ANNOTATION_MARKING);

  private final IPreferenceStore store = EditorsUI.getPreferenceStore();

  private boolean isHidden;

  private IDecoratorManager decoratorManager;

  @Override
  public Object execute(final ExecutionEvent event) throws ExecutionException {
    this.decoratorManager = Activator.getDefault().getWorkbench().getDecoratorManager();

    if (!this.isHidden) {
      this.isHidden = true;
      this.setStore(false);
      this.setDecorator(false);
    } else {
      this.isHidden = false;
      this.setStore(true);
      this.setDecorator(true);
    }
    this.store.needsSaving();

    final IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
    final ICommandService commandService = window.getService(ICommandService.class);
    if (commandService != null) {
      commandService.refreshElements(COMMAND_ID, null);
    }
    return null;
  }

  private void setDecorator(final boolean state) {
    try {
      this.decoratorManager.setEnabled(MarkerFactory.ECORE_DECORATOR, state);
      this.decoratorManager.setEnabled(MarkerFactory.FILE_DECORATOR, state);
    } catch (final CoreException e) {
      e.printStackTrace();
    }
  }

  private void setStore(final boolean state) {
    this.store.setValue(this.prefMarking.getOverviewRulerPreferenceKey(), state);
    this.store.setValue(this.prefMarking.getVerticalRulerPreferenceKey(), state);
    this.store.setValue(this.prefMarking.getTextPreferenceKey(), state);
    this.store.setValue(this.prefMapping.getOverviewRulerPreferenceKey(), state);
    this.store.setValue(this.prefMapping.getVerticalRulerPreferenceKey(), state);
    this.store.setValue(this.prefMapping.getTextPreferenceKey(), state);
    if (state) {
      this.store.setValue(this.prefMarking.getColorPreferenceKey(), "0,0,255");
      this.store.setValue(this.prefMapping.getColorPreferenceKey(), "255,0,0");
    }
  }

  @Override
  public void updateElement(final UIElement element,
      @SuppressWarnings("rawtypes") final Map parameters) {
    // are trace elements visible or not? determine and handle the action.
    this.isHidden = !this.store.getBoolean(this.prefMarking.getTextPreferenceKey());
    if (!this.isHidden) {
      element.setText("Hide trace elements");
    } else {
      element.setText("Show trace elements");
    }
  }
}
