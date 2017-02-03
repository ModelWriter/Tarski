package eu.modelwriter.core.alloyinecore.visitor;

import eu.modelwriter.core.alloyinecore.structure.Element;
import org.antlr.v4.runtime.ParserRuleContext;

public interface IVisitor<T> {

    T visit(Element<? extends ParserRuleContext> element);

    T visitChildren(Element<? extends ParserRuleContext> element);

}
