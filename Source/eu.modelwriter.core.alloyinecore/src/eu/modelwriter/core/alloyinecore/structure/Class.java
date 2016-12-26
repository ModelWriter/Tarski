/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016, Ferhat Erata <ferhat@computer.org>
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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;

import java.util.ArrayList;
import java.util.List;

public class Class extends Classifier<EClassContext> {
    public boolean isAbstract = false;
    public boolean isInterface = false;
    public final List<Class> superTypes = new ArrayList<>();
    public final List<Operation> operations = new ArrayList<>();
    public final List<StructuralFeature> structuralFeatures = new ArrayList<>();

    public Class(String name, EClassContext context) {
        super(name, context);
        this.token = context.name.getStart();
    }

    public Class getSuperType(String qualifiedName) {
        return Document.getInstance().getClass(qualifiedName);
    }

    public List<Class> getAllSuperTypes() {
        List<Class> types = new ArrayList<>();
        types.addAll(this.superTypes);
        for (Class c : this.superTypes){
            types.addAll(c.getAllSuperTypes());
        }
        return types;
    }

    public Operation getOperation(String qualifiedName){
        return (Operation) Document.getInstance().getElement(qualifiedName);
    }


    public StructuralFeature getStructuralFeature(String qualifiedName){
        return (StructuralFeature) Document.getInstance().getElement(qualifiedName);
    }

    @Override
    public String toString() {
        return "Class{" +
                "name='" + getName() + '\'' +
                ", visibility='" + visibility + '\'' +
                ", qualified='" + Document.getQualifiedName(this) + '\'' +
                ", isAbstract=" + isAbstract +
                ", isInterface=" + isInterface +
                ", superTypes=" + superTypes +
                ", operations=" + operations +
                ", structuralFeatures=" + structuralFeatures +
                "}";
    }
}
