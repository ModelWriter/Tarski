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

import eu.modelwriter.core.alloyinecore.Internal.Console;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Element<C extends ParserRuleContext>{
    private final C context;
    private Element owner;
    private final List<Element> ownedElements = new ArrayList<>();

    public Element(C context) { this.context = context;}

    public final C getContext() { return this.context; }

    public final List<Element> getOwnedElements() { return ownedElements; }

    public final boolean hasOwnedElements(){ return !ownedElements.isEmpty(); }

    public <K extends Element> void addOwnedElement(K child) {
        ownedElements.add(child);
        child.setOwner(this);
    }

    String getName(){
        if (this.getOwner() != null)
            return "::" + this.getClass().getSimpleName() + "." + this.getOwner().getOwnedElements().indexOf(this);
        else
            return this.getClass().getSimpleName();
    }

    public final String getUniqueName(){
        String name = this.getName();
        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            name = parent.getName() + name;
        }
        return name;
    }

    private String getPath(){
        if (this.getOwner() != null)
            return "/" + this.getClass().getSimpleName() + "@" + this.getOwner().getOwnedElements().indexOf(this);
        else
            return "/";
    }

    public final String getFullPath(){
        String path = this.getPath();
        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            path = parent.getPath() + path;
        }
        return path;
    }

    public Token getToken() { return this.context.start; }

    public final List<Element> getOwnedElements(java.lang.Class c){
        List<Element> elements = new ArrayList<>();
        for(Element e : getOwnedElements())
            if (c.isInstance(e)) elements.add(e);
        return elements;
    }

    public final Element findFirstOwnedElementOrElseNull(java.lang.Class c){
        return this.getOwnedElements().stream().filter(c::isInstance).findFirst().orElse(null);
    }

    public final void setOwner(final Element owner) { this.owner = owner; }

    public final Element getOwner() { return owner; }


    public String getSuffix(){ return ""; }

    public String getLabel(){
        return getContext().start.getInputStream().getText(new Interval(getContext().start.getStartIndex(), getContext().stop.getStopIndex()));
    };

    public void printTree(){
        StringBuilder tree = new StringBuilder();
        tree.append(this.getLabel());
        System.out.println(Console.BOLD + "[OUTLINE]" + Console.RESET);
        traverse(this, 0);
    }

    private void traverse(Element<? extends ParserRuleContext> element, int tabCount){
        for (int i = 0; i < tabCount; i++) {
            System.out.print("\t");
        }
        if (element instanceof IVisibility)
            System.out.print(((IVisibility) element).getVisibility() + " ");
        else System.out.print("  ");
        System.out.print("[" + (element instanceof Class && ((Class)element).isAbstract() ? "abstract " : "") + element.getClass().getSimpleName() + "] "
                +  element.getLabel() + element.getSuffix() );
//        System.out.print(" -- [" + element.getFullPath() +  "]");
//        System.out.print( " -- (" + String.join(",", String.valueOf(element.getLine()), String.valueOf(element.getStart()), String.valueOf(element.getStop())) + ") ");
//        if (element instanceof Object)
//            System.out.print(" -- [" + ((Object)element).getURI() +   "]");
        //        if (element instanceof Class) System.out.println("{" + element.getOwnedElements(Operation.class)+ "}");
        System.out.println();
        List<Element> elements = element.getOwnedElements();
        for(Element e: elements) {
            traverse(e, tabCount + 1);
        }
    }

//    private void traverse(Element<? extends ParserRuleContext> element, int tabCount){
//        for (int i = 0; i < tabCount; i++) {
//            System.out.print("\t");
//        }
//
//        if (element instanceof IVisibility)
//            System.out.print(((IVisibility) element).getVisibility() + " ");
//        else System.out.print("  ");
//
//        System.out.print("[" + (element instanceof Class && ((Class)element).isAbstract() ? Console.UNDERLINE : "") + element.getClass().getSimpleName() + Console.RESET + "] ");
//
//        if (element instanceof PrimitiveType && ((Object)element).getEObject() != null) {
//            System.out.print(Console.BOLD + Console.RED  + element.getLabel() + Console.RESET + " ");
//        }else if (element instanceof GenericType && ((Object)element).getEObject() != null) {
//            System.out.print(Console.BOLD + Console.RED  + element.getLabel() + Console.RESET + " ");
//        }
//        else System.out.print(Console.RED + element.getLabel() + Console.RESET + " ");
//
//        if (!element.getSuffix().equals("")) System.out.print(Console.PURPLE + element.getSuffix() + Console.RESET);
////        System.out.print(" -- [" + Console.YELLOW + element.getFullPath() + Console.RESET +  "]");
//
//        if (element instanceof Object && ((Object) element).getEObject() != null) {
//            String name = ((Object) element).getEObject().getClass().getSimpleName();
//            System.out.print(" -- [" + Console.CYAN + name.substring(0 , name.lastIndexOf("Imp")) + Console.RESET + "]");
//        }
//        if (element instanceof NamedElement || element instanceof Import)
//            System.out.print(" -- [" + Console.GREEN + element.getUniqueName() + Console.RESET +  "]");
////        System.out.print( " -- (" + String.join(",", String.valueOf(element.getLine()), String.valueOf(element.getStart()), String.valueOf(element.getStop())) + ") ");
//        if (element instanceof Object && ((Object) element).getEObject() != null) {
//            System.out.print(" -- [" + Console.BLUE + ((Object) element).getURI().toString() + Console.RESET + "]");
//        }
////        if (element instanceof Class) System.out.println("{" + element.getOwnedElements(Operation.class)+ "}");
//        System.out.println();
//        List<Element> elements = element.getOwnedElements();
//        for(Element e: elements) {
//            traverse(e, tabCount + 1);
//        }
//    }

    public int getLine(){ return context.start.getLine(); }

    public int getStart() { return context.start.getStartIndex();}

    public int getStop(){ return context.start.getStopIndex(); }
}

