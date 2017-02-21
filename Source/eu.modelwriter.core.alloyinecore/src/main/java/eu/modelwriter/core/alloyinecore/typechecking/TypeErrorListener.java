package eu.modelwriter.core.alloyinecore.typechecking;

import eu.modelwriter.core.alloyinecore.structure.base.Element;

import java.util.Set;

public interface TypeErrorListener {

    void onTypeError(String message, Set<Element<?>> relatedElements);

    void onTypeWarning(String message, Set<Element<?>> relatedElements);
}
