package eu.modelwriter.core.alloyinecore.visitor;

import eu.modelwriter.core.alloyinecore.structure.Element;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class ElementVisitorImpl<T> extends BaseVisitorImpl<T> {

    @Override
    public T visit(Element<? extends ParserRuleContext> element) {
        visitElement(element);
        return element.accept(this);
    }

    @Override
    public T visitChildren(Element<? extends ParserRuleContext> element) {
        T result = defaultResult();
        for (Element<?> ownedElement : element.getOwnedElements()) {
            if (!shouldVisitNextChild(ownedElement, result)) {
                break;
            }
            visitElement(ownedElement);
            T childResult = ownedElement.accept(this);
            result = aggregateResult(result, childResult);
        }
        return result;
    }

    public T visitElement(Element element) {
        return null;
    }
}
