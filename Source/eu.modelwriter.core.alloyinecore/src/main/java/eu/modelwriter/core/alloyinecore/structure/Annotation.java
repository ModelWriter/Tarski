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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAnnotationContext;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.eclipse.emf.ecore.EAnnotation;

public class Annotation extends ModelElement<EAnnotation, EAnnotationContext> {

    public Annotation(EAnnotation eAnnotation, EAnnotationContext context) {
        super(eAnnotation, context);
    }

    @Override
    public String getLabel() {
        if (getContext().source != null) {
            String source = getContext().source.getText().replace("'", "");
            if (source.lastIndexOf("/") > -1)
                return source.substring(source.lastIndexOf("/") + 1, source.length());
            else return source;
        } else {
            return "";
        }
    }

    @Override
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitAnnotation(this);
    }
}
