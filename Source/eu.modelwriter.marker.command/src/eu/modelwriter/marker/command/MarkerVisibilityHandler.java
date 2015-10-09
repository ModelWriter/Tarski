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
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.ui.IDecoratorManager;
import org.eclipse.ui.editors.text.EditorsUI;
import org.eclipse.ui.texteditor.AnnotationPreference;

import eu.modelwriter.marker.internal.AnnotationFactory;
import eu.modelwriter.marker.internal.MarkerFactory;

public class MarkerVisibilityHandler extends AbstractHandler {
  public static String COMMAND_ID = "eu.modelwriter.marker.command.markervisibility";

  private IDecoratorManager decoratorManager;
  private boolean isHidden = false;
  private AnnotationPreference prefMapping;
  private AnnotationPreference prefMarking;
  private IPreferenceStore store;

  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    this.prefMarking = EditorsUI.getAnnotationPreferenceLookup()
        .getAnnotationPreference(AnnotationFactory.ANNOTATION_MARKING);
    this.prefMapping = EditorsUI.getAnnotationPreferenceLookup()
        .getAnnotationPreference(AnnotationFactory.ANNOTATION_MAPPING);
    this.store = EditorsUI.getPreferenceStore();
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

    return null;
  }

  private void setDecorator(boolean state) {
    try {
      this.decoratorManager.setEnabled(MarkerFactory.ECORE_DECORATOR, state);
      this.decoratorManager.setEnabled(MarkerFactory.FILE_DECORATOR, state);
    } catch (CoreException e) {
      e.printStackTrace();
    }
  }

  private void setStore(boolean state) {
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
}
