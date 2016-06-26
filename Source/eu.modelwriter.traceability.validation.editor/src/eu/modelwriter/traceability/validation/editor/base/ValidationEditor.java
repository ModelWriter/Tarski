package eu.modelwriter.traceability.validation.editor.base;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.text.IDocument;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.editors.text.TextEditor;

import eu.modelwriter.traceability.validation.core.fol.Test;
import eu.modelwriter.traceability.validation.core.fol.model.Atom;
import eu.modelwriter.traceability.validation.core.fol.model.Relation;
import eu.modelwriter.traceability.validation.core.fol.model.Universe;
import eu.modelwriter.traceability.validation.editor.base.color.ColorManager;
import eu.modelwriter.traceability.validation.editor.base.document.ValidationDocumentProvider;

public class ValidationEditor extends TextEditor {

  private static List<String> relationNames;

  private static List<String> atomNames;

  public static List<String> getAtomNames() {
    return atomNames;
  }

  public static List<String> getRelationNames() {
    return relationNames;
  }

  private final ColorManager colorManager;

  public ValidationEditor() {
    super();
    relationNames = new ArrayList<>();
    atomNames = new ArrayList<>();
    this.colorManager = new ColorManager();
    this.setSourceViewerConfiguration(new ValidationConfiguration(this.colorManager));
    this.setDocumentProvider(new ValidationDocumentProvider());
  }

  @Override
  public void createPartControl(final Composite parent) {
    super.createPartControl(parent);
    final IDocument document = this.getDocumentProvider().getDocument(this.getEditorInput());
    final Universe universe = Test.parseAndGetUniverse(document.get());

    for (final Atom atom : universe.getAtoms()) {
      atomNames.add(atom.getText());
    }

    for (final Relation relation : universe.getRelations()) {
      relationNames.add(relation.getName());
    }
  }

  @Override
  public void dispose() {
    this.colorManager.dispose();
    super.dispose();
  }
}
