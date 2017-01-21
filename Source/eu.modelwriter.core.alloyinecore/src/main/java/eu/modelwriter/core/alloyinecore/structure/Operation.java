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

package eu.modelwriter.core.alloyinecore.structure;

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.emf.ecore.EOperation;

import java.util.ArrayList;
import java.util.List;

public final class Operation extends TypedElement<EOperation, EOperationContext> implements IVisibility{

    public Operation(EOperation eOperation, EOperationContext context) {
        super(eOperation, context);
    }

    public Operation(EOperationContext context) {
        super(context);
    }

    public List<Parameter> getParameters(){
        List<Parameter> parameters = new ArrayList<>();
        for(Element e : getOwnedElements())
            if (e instanceof Parameter) parameters.add((Parameter) e);
        return parameters;
    }

    @Override
    public Visibility getVisibility() {
        Visibility visibility = Visibility.PACKAGE;
        if (getContext().visibility != null) {
            String text = getContext().visibility.getText();
            try {
                visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
            } catch (IllegalArgumentException e){visibility = Visibility.PACKAGE;}
        }
        return visibility;
    }

    @Override
    public String getLabel() {
        int start;
        int stop;
        if (getContext().name != null) {
            start = getContext().name.start.getStartIndex();
            stop = getContext().name.stop.getStopIndex();
        } else {
            start = getContext().start.getStartIndex();
            stop = getContext().stop.getStopIndex();
        }

        if (getContext().eParameters != null && !getContext().eParameters.isEmpty()){
            stop = getContext().eParameters.get(getContext().eParameters.size()-1).stop.getStopIndex()+1;
        }

        if (getContext().eReturnType != null) {
            stop = getContext().eReturnType.stop.getStopIndex();
        }
        return getContext().start.getInputStream().getText(new Interval(start, stop)).replaceAll("\\s+", " ").replaceAll("(\\w)(\\s)(<)","$1$3") +
                (getContext().eParameters.isEmpty() && getContext().eReturnType == null  ? "()" : "");
    }

    @Override
    public String getSuffix() {
        return getContext().ownedMultiplicity != null ? TypedElement.getMultiplicity(getContext().ownedMultiplicity) : "void";
    }

    @Override
    public int getLine() {
        if (getContext().name != null)
            return getContext().name.start.getLine();
        else return super.getLine();
    }

    @Override
    protected String getName(){
        if (this.getContext().name != null)
            return "->" + this.getContext().name.getText();
        else
            return super.getName();
    }

    @Override
    public int getStart() {
        if (getContext().name != null)
            return getContext().name.start.getStartIndex();
        else return super.getLine();
    }

    @Override
    public int getStop() {
        if (getContext().name != null)
            return getContext().name.start.getStopIndex();
        else return super.getLine();
    }
}
