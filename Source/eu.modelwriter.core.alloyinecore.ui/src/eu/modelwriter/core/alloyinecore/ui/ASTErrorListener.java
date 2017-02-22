package eu.modelwriter.core.alloyinecore.ui;

import java.util.Set;

import org.antlr.v4.runtime.Token;

public interface ASTErrorListener {
  void onSyntaxError(Token offendingSymbol, String msg);

  void onTypeError(String message, Set<Token> relatedElements);

  void onTypeWarning(String message, Set<Token> relatedElements);
}
