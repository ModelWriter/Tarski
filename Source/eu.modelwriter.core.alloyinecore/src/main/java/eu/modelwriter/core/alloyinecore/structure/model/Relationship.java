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

package eu.modelwriter.core.alloyinecore.structure.model;


import eu.modelwriter.core.alloyinecore.structure.base.Element;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * A relationship represents a relationship between source and target elements
 * @param <S> source or owner element
 * @param <T> target element
 * @param <C> context
 */
public abstract class Relationship<S extends Element, T extends  Element, C extends ParserRuleContext> extends Element<C> {

    private final S source;
    private T target;

    public Relationship(S source, C context) {
        super(context);
        this.source = source;
    }

    public Relationship(S source, T target, C context) {
        super(context);
        this.source = source;
        this.target = target;
    }

    @Override
    public String getLabel() {
        return Element.getNormalizedText(getContext());
    }

    public void setTarget(T target) {
        this.target = target;
    }
}
