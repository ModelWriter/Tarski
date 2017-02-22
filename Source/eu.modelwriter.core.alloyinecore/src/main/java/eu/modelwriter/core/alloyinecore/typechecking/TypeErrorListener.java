package eu.modelwriter.core.alloyinecore.typechecking;

import org.antlr.v4.runtime.Token;

import java.util.Set;

public interface TypeErrorListener {

    void onTypeError(String message, Set<Token> relatedElements);

    void onTypeWarning(String message, Set<Token> relatedElements);
}
