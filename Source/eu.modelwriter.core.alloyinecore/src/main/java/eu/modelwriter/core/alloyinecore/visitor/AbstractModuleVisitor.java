package eu.modelwriter.core.alloyinecore.visitor;

import eu.modelwriter.core.alloyinecore.structure.Element;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.List;

public abstract class AbstractModuleVisitor<T extends Element> implements AlloyInEcoreVisitor<T> {

    @Override
    public T visit(Element<? extends ParserRuleContext> element) {
        return visitChildren(element);
    }

    @Override
    public T visitChildren(Element<? extends ParserRuleContext> element) {
        T result = defaultResult();
        List<Element> ownedElements = element.getOwnedElements();
        for (Element ownedElement : ownedElements) {
            if (!shouldVisitNextChild(ownedElement, result)) {
                break;
            }
            T childResult = ownedElement.accept(this);
            result = aggregateResult(result, childResult);
        }
        return result;
    }

    protected T defaultResult() {
        return null;
    }

    protected T aggregateResult(T aggregate, T nextResult) {
        return nextResult;
    }

    protected boolean shouldVisitNextChild(Element<? extends ParserRuleContext> element, T currentResult) {
        return true;
    }
}
