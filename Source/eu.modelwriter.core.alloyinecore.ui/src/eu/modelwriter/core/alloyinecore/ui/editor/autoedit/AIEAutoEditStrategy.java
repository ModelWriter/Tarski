package eu.modelwriter.core.alloyinecore.ui.editor.autoedit;

import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;

public class AIEAutoEditStrategy implements IAutoEditStrategy {

  private void configureCaret(final DocumentCommand command) {
    command.caretOffset = command.offset + 1;
    command.shiftsCaret = false;
  }

  @Override
  public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
    if (command.text.equals("(")) {
      command.text = "()";
      this.configureCaret(command);
    } else if (command.text.equals("[")) {
      command.text = "[]";
      this.configureCaret(command);
    } else if (command.text.equals("{")) {
      command.text = "{}";
      this.configureCaret(command);
    }
  }
}
