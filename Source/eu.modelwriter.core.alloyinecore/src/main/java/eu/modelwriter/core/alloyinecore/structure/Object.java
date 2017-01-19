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

import org.antlr.v4.runtime.ParserRuleContext;
import org.eclipse.emf.ecore.EObject;


public abstract class Object<E extends EObject, C extends ParserRuleContext> extends Element<C> {
    private String qualifiedPath;
    private E eObject;
    private String qualifiedName;

    public Object(String qPath, E eObject, C context) {
        super(context);
        this.eObject = eObject;
        this.qualifiedPath = qPath;
    }

    public Object(E eObject, C context){
        super(context);
        this.eObject = eObject;
    }


    public Object(C context){
        super(context);
    }

    public void seteObject(E eObject) { this.eObject = eObject; }

    public E getEObject() { return eObject; }

    public void setQualifiedPath(String qualifiedPath) { this.qualifiedPath = qualifiedPath; }

    public String getQualifiedPath() { return this.qualifiedPath; }

    public String getQualifiedName() { return qualifiedName; }

    public void setQualifiedName(String qualifiedName) { this.qualifiedName = qualifiedName; }

}
