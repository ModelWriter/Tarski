/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017, Ferhat Erata <ferhat@computer.org>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package eu.modelwriter.core.alloyinecore.visitor;

import eu.modelwriter.core.alloyinecore.structure.base.Element;
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
