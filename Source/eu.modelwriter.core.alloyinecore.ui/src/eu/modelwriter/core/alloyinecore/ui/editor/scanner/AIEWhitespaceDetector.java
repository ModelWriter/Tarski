package eu.modelwriter.core.alloyinecore.ui.editor.scanner;

import org.eclipse.jface.text.rules.IWhitespaceDetector;

/**
 * A AlloyInEcore aware white space detector.
 */
public class AIEWhitespaceDetector implements IWhitespaceDetector {

  @Override
  public boolean isWhitespace(final char c) {
    return Character.isWhitespace(c);
  }
}
