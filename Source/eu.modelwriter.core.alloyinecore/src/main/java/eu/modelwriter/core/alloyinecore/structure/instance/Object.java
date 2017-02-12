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

package eu.modelwriter.core.alloyinecore.structure.instance;


import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.structure.model.TypedElement;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.eclipse.emf.ecore.EObject;

import java.util.List;

public class Object extends eu.modelwriter.core.alloyinecore.structure.base.Object<EObject, AlloyInEcoreParser.EObjectContext> {
    public Object(EObject eObject, AlloyInEcoreParser.EObjectContext context) {
        super(eObject, context);
    }

    public Object(AlloyInEcoreParser.EObjectContext context) {
        super(context);
    }

    public Class getClassifier(){
        return null;
    }

    public List<Slot> getSlots(){
        return this.getOwnedElements(Slot.class);
    }

    @Override
    public String getLabel() {
        String type = "";
        if (getContext().name != null) {
            int start = getContext().name.start.getStartIndex();
            int stop = getContext().name.stop.getStopIndex();
            type = Element.getNormalizedText(getContext(), start, stop);
        }
        return  type;
    }

    @Override
    public String getSuffix() {
        return getContext().id != null ? ": " + getContext().id.getText().replace("\"", "") : "";
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitObject(this);
    }
}
