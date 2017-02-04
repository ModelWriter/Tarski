package eu.modelwriter.core.alloyinecore.ui.editor.autoedit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.DocumentCommand;
import org.eclipse.jface.text.IAutoEditStrategy;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IRegion;

public class AIEAutoEditStrategy implements IAutoEditStrategy {

  private void configureCaret(final DocumentCommand command, int caretInc) {
    command.caretOffset = command.offset + caretInc;
    command.shiftsCaret = false;
  }

  @Override
  public void customizeDocumentCommand(final IDocument document, final DocumentCommand command) {
    if (command.text.equals("(")) {
      command.text = "()";
      configureCaret(command, 1);
    } else if (command.text.equals("[")) {
      command.text = "[]";
      configureCaret(command, 1);
    } else if (command.text.equals("'")) {
      command.text = "''";
      configureCaret(command, 1);
    } else if (command.text.equals("\"")) {
      command.text = "\"\"";
      configureCaret(command, 1);
    } else if (command.text.equals("{")) {
      String indent = getIndent(document, command);
      command.text = "\n" + indent + "{\n" + indent + "    \n" + indent + "}";
      configureCaret(command, 3 + indent.length() * 2 + 4);
    }
  }

  private String getIndent(IDocument document, DocumentCommand command) {
    String result = "";
    try {
      IRegion info = document.getLineInformationOfOffset(command.offset);
      String text = document.get(info.getOffset(), info.getLength());
      Matcher matcher = Pattern.compile("^(\\s)*(\\w)").matcher(text);
      if (matcher.find()) {
        int indexOf = text.indexOf(matcher.group(2));
        result = text.substring(0, indexOf);
      }
    } catch (BadLocationException e) {
      result = "";
    }
    return result;
  }
}
