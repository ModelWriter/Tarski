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

package eu.modelwriter.core.alloyinecore.structure.imports;

import eu.modelwriter.core.alloyinecore.recognizer.imports.ImportsParser.IPackageContext;
import eu.modelwriter.core.alloyinecore.structure.model.IVisibility;
import eu.modelwriter.core.alloyinecore.structure.model.Visibility;
import eu.modelwriter.core.alloyinecore.structure.base.Element;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.antlr.v4.runtime.Token;

public final class ImportedPackage extends Element<IPackageContext> implements IVisibility {

    public ImportedPackage(IPackageContext context) {
        super(context);
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
        String name;
        String nsURI;
        if (getContext().name != null){
            name = getContext().name.getText();
        } else {
            name = "Package";
        }
        if (getContext().nsURI != null){
            nsURI = getContext().nsURI.getText();
        }else {
            nsURI = "";
        }
        return name + " : " + nsURI;
    }

    @Override
    public Visibility getVisibility() {
        Visibility visibility = Visibility.PACKAGE;
        if (getContext().visibility() != null) {
            String text = getContext().visibility().getText();
            try {
                visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
            } catch (IllegalArgumentException e){visibility = Visibility.PACKAGE;}
        }
        return visibility;
    }

    protected String getName(){
        if (this.getContext().name != null)
            return "::" + this.getContext().name.getText();
        else
            return super.getName();
    }

    @Override
    public int getLine() {
        if (getContext().name != null)
            return getContext().name.start.getLine();
        else return super.getLine();
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
    public <T> T accept(IVisitor<? extends T> visitor) {
        return visitor.visitImportedPackage(this);
    }
}
