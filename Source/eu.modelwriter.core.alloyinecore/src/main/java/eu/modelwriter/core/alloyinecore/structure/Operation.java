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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EGenericElementTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.visitor.AlloyInEcoreVisitor;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.ecore.EOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public Token getToken() {
        if (getContext().name != null)
            return getContext().name.start;
        else
            return super.getToken();
    }

    @Override
    public String getLabel() {
        String name = "";
        if (getContext().name != null) {
            name = getContext().name.getText();
        }
        List<String> parameterTypeTexts = new ArrayList<>();
        for(Parameter e : this.getOwnedElements(Parameter.class)){
            EGenericElementTypeContext typeRef = e.getContext().eParameterType;
            if (typeRef != null) parameterTypeTexts.add(Element.getNormalizedText(typeRef));
        }
        return name + "(" + String.join(", ", parameterTypeTexts) + ")";
    }

    @Override
    public String getSuffix() {
        String throwsText = "";
        if (!getContext().ownedException.isEmpty()){
            throwsText = "throws " + String.join(", ", getContext().ownedException.stream()
                    .map(eGenericExceptionContext -> Element.getNormalizedText(eGenericExceptionContext.eGenericType)).collect(Collectors.toList()));
        }

        if (getContext().eReturnType == null ) {
            return ": void" + " " + throwsText;
        } else if (getContext().ownedMultiplicity != null ) {
            String multiplicity = TypedElement.getMultiplicity(getContext().ownedMultiplicity);
            if (getContext().eReturnType != null) {
                EGenericElementTypeContext ctx = getContext().eReturnType;
                String typeRefText = Element.getNormalizedText(ctx);
                return ": " + typeRefText + "" + multiplicity + " " + throwsText;
            } else {
                return ": " + multiplicity + " " + throwsText;
            }
        } else {
            return "[1]" + " " + throwsText;
        }
    }

    @Override
    public int getLine() {
        if (getContext().name != null)
            return getContext().name.start.getLine();
        else return super.getLine();
    }

    @Override
    protected String getName() {
        String name = "";
        if (this.getContext().name != null)
            name = "->" + this.getContext().name.getText();
        if (!this.getContext().eParameter().isEmpty()) {
            name = name + "#" + String.valueOf(this.getContext().eParameter().size());
            for (EParameterContext p : this.getContext().eParameter()) {
                if (p.eParameterType != null) {
                    if (p.eParameterType.eGenericType() != null && p.eParameterType.eGenericType().ownedPathName != null)
                        name = String.join("#", name, p.eParameterType.eGenericType().ownedPathName.getText());
                    else name = String.join("#", name, p.eParameterType.getText());
                }
            }
        } else {
            name = name+ "#0";
        }
        return name;
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

    @Override
    public <T> T accept(AlloyInEcoreVisitor<? extends T> visitor) {
        return visitor.visitOperation(this);
    }
}
