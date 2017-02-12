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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.PackageImportContext;
import eu.modelwriter.core.alloyinecore.structure.base.*;
import eu.modelwriter.core.alloyinecore.structure.base.Object;
import eu.modelwriter.core.alloyinecore.translator.EcoreInstanceTranslator;
import eu.modelwriter.core.alloyinecore.translator.EcoreTranslator;
import eu.modelwriter.core.alloyinecore.visitor.IVisitor;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.Token;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.io.IOException;
import java.util.List;

public class Import extends Object<EObject, PackageImportContext> implements INamespace {

    public Import(EObject eObject, PackageImportContext context) {
        super(eObject, context);
    }

    @Override
    public String getPath() {
        if (getContext().ownedPathName != null)
            return getContext().ownedPathName.getText().replace("'", "");
        else return null;
    }

    @Override
    public void loadNamespace(Repository repository){
        if (getPath() != null) {
            Resource resource = getResource();
            String recore;
            if (resource.getURI().isFile()) {
                System.out.println("[" + getKey() +"] Resource is file in the classpath");
            } else if (resource.getURI().isPlatform()) {
                System.out.println("[" + getKey() +"] Resource is platform");
            } else if (resource.getURI().isPlatformPlugin()) {
                System.out.println("[" + getKey() +"] Resource is platform plugin");
            } else if (resource.getURI().isPlatformResource()) {
                System.out.println("[" + getKey() +"] Resource is platform resource");
            } else {
                System.out.println("[" + getKey() +" ]Resource is file in the JAR");
            }
            System.out.print(" [" + resource.getURI().toFileString() + "]");
            System.out.println();

            if (getEObject() instanceof ENamedElement)
            {
                EcoreTranslator modelTranslator;
                try {
                    modelTranslator = new EcoreTranslator(repository);
                    recore= modelTranslator.translate(getPath());
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                    return;
                }
                ANTLRInputStream input = new ANTLRInputStream(recore.toCharArray(), recore.length());
                Repository.importPackage(input, this);
            }else{
                EcoreInstanceTranslator instanceTranslator;
                try {
                    instanceTranslator = new EcoreInstanceTranslator(repository);
                    recore= instanceTranslator.translate(getPath());
                } catch (IOException | NullPointerException e) {
                    e.printStackTrace();
                    return;
                }
                ANTLRInputStream input = new ANTLRInputStream(recore.toCharArray(), recore.length());
                Repository.importInstance(input, this);
            }

        }
    }

    @Override
    public List<IName> getNames() {
        return null;
    }

    @Override
    public String getKey(){
        return getContext().name != null ? getContext().name.getText()
                : getRootObject() instanceof ENamedElement
                ? ((ENamedElement) getRootObject()).getName() : null;
    }

    protected String getName(){
        String name = "";
        if (this.getContext().name != null) {
            name = "::" + this.getContext().name.getText();
        }
        else if (this.getEObject() != null && this.getEObject() instanceof ENamedElement) {
            ENamedElement pack = (ENamedElement) this.getEObject();
            if (pack.getName() != null && !pack.getName().isEmpty())
                name = "::" + pack.getName();
        } else if (this.getURI() != null)
            name = this.getURI().lastSegment();
        return name;
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
        int start;
        int stop;
        if (getContext().name != null) {
            start = getContext().name.start.getStartIndex();
        } else {
            start = getContext().start.getStartIndex();
        }

        if (getContext().ownedPathName != null) {
            stop = getContext().ownedPathName.getStopIndex();
        } else {
            stop = getContext().stop.getStopIndex();
        }
        return  Element.getNormalizedText(getContext(), start, stop);
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
        return visitor.visitImport(this);
    }

}
