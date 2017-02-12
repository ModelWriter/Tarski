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

package eu.modelwriter.core.alloyinecore.structure.base;

import eu.modelwriter.core.alloyinecore.internal.Console;
import eu.modelwriter.core.alloyinecore.structure.model.*;
import eu.modelwriter.core.alloyinecore.structure.model.Class;
import eu.modelwriter.core.alloyinecore.visitor.IVisitable;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;

import java.lang.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Element<C extends ParserRuleContext> implements IVisitable {
    private final C context;
    private Element owner;
    private final List<Element> ownedElements = new ArrayList<>();

    public Element(C context) {
        this.context = context;
    }

    public final C getContext() {
        return this.context;
    }

    public final List<Element> getOwnedElements() {
        return ownedElements;
    }

    public final boolean hasOwnedElements() {
        return !ownedElements.isEmpty();
    }

    public final <K extends Element> boolean deleteOwnedElement(K child){
        return this.ownedElements.remove(child);
    }

    public <K extends Element> void addOwnedElement(K child) {
        if (child != null) {
            ownedElements.add(child);
            child.setOwner(this);
        }
    }

    public final <K extends Element> void addOwnedElements(final K... child) {
        for (K aChild : child) {
            addOwnedElement(aChild);
        }
    }

    public final <K extends Element> void addOwnedElements(final List<K> children) {
        for (K child : children) {
            addOwnedElement(child);
        }
    }

    protected String getName() {
        if (this.getOwner() != null) {
            return "::" + this.getClass().getSimpleName() + "." + this.getContext().getText().hashCode();
        } else
            return this.getClass().getSimpleName();
    }

    public final String getUniqueName() {
        String name = this.getName();
        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            name = parent.getName() + name;
        }
        return name;
    }

    private String getLocation() {
        if (this.getOwner() != null)
            return "/" + this.getClass().getSimpleName() + "@" + this.getOwner().getOwnedElements().indexOf(this);
        else
            return "/";
    }

    public final String getFullLocation() {
        String location = this.getLocation();
        for (Element parent = this.getOwner(); parent != null; parent = parent.getOwner()) {
            location = parent.getLocation() + location;
        }
        return location;
    }

    public Token getToken() {
        return this.context.start;
    }

    public final <T extends Element> List<T> getOwnedElements(java.lang.Class<T> t) {
        List<T> elements = new ArrayList<>();
        for (Element e : getOwnedElements())
            if (t.isInstance(e)) elements.add((T) e);
        return elements;
    }

    public final Element getOwnedElement(java.lang.Class c) {
        return this.getOwnedElements().stream().filter(c::isInstance).findFirst().orElse(null);
    }

    public final void setOwner(final Element owner) {
        this.owner = owner;
    }

    public final Element getOwner() {
        return owner;
    }


    public String getSuffix() {
        return "";
    }

    public String getLabel() {
        return Element.getNormalizedText(getContext());
    }

    public void printTree() {
        System.out.println(Console.BOLD + "[OUTLINE]" + Console.RESET);
        traverse(this, 0);
    }

//    private void traverse(Element<? extends ParserRuleContext> element, int tabCount){
//        for (int i = 0; i < tabCount; i++) {
//            System.out.print("\t");
//        }
//        if (element instanceof IVisibility)
//            System.out.print(((IVisibility) element).getVisibility() + " ");
//        else System.out.print("  ");
//        System.out.print("[" + (element instanceof Class && ((Class)element).isAbstract() ? "abstract " : "") + element.getClass().getSimpleName() + "] "
//                +  element.getLabel() + element.getSuffix() );
////        System.out.print(" -- [" + element.getFullLocation() +  "]");
////        System.out.print( " -- (" + String.join(",", String.valueOf(element.getLine()), String.valueOf(element.getStart()), String.valueOf(element.getStop())) + ") ");
////        if (element instanceof Object)
////            System.out.print(" -- [" + ((Object)element).getURI() +   "]");
//        //        if (element instanceof Class) System.out.println("{" + element.getOwnedElements(Operation.class)+ "}");
//        System.out.println();
//        List<Element> elements = element.getOwnedElements();
//        for(Element e: elements) {
//            traverse(e, tabCount + 1);
//        }
//    }

    private void traverse(Element<? extends ParserRuleContext> element, int tabCount) {
        for (int i = 0; i < tabCount; i++) {
            System.out.print("\t");
        }

        if (element instanceof IVisibility)
            System.out.print(((IVisibility) element).getVisibility() + " ");
        else System.out.print("  ");

        System.out.print("[" + (element instanceof Class && ((eu.modelwriter.core.alloyinecore.structure.model.Class) element).isAbstract() ? Console.UNDERLINE : "") + element.getClass().getSimpleName() + Console.RESET + "] ");

        if (element instanceof PrimitiveType && ((Object) element).getEObject() != null) {
            System.out.print(Console.BOLD + Console.RED + element.getLabel() + Console.RESET + " ");
        } else if ((element instanceof GenericElementType || element instanceof GenericTypeArgument ||
                element instanceof GenericException || element instanceof GenericSuperType) && ((Object) element).getEObject() != null) {
            System.out.print(Console.BOLD + Console.RED + element.getLabel() + Console.RESET + " ");
        } else System.out.print(Console.RED + element.getLabel() + Console.RESET + " ");

        if (!element.getSuffix().equals("")) System.out.print(Console.PURPLE + element.getSuffix() + Console.RESET);
//        System.out.print(" -- [" + Console.YELLOW + element.getFullLocation() + Console.RESET +  "]");

        if (element instanceof Object && ((Object) element).getEObject() != null) {
            String name = ((Object) element).getEObject().getClass().getSimpleName();
            System.out.print(" -- [" + Console.CYAN + name.substring(0, name.lastIndexOf("Imp")) + Console.RESET + "]");
        }
        if (element instanceof NamedElement || element instanceof Import)
            System.out.print(" -- [" + Console.GREEN + element.getUniqueName() + Console.RESET + "]");
//        System.out.print( " -- (" + String.join(",", String.valueOf(element.getLine()), String.valueOf(element.getStart()), String.valueOf(element.getStop())) + ") ");
        if (element instanceof Object && ((Object) element).getEObject() != null) {
            System.out.print(" -- [" + Console.BLUE + ((Object) element).getURI().toString() + Console.RESET + "]");
        }
//        if (element instanceof Class) System.out.println("{" + element.getOwnedElements(Operation.class)+ "}");
        System.out.println();
        List<Element> elements = element.getOwnedElements();
        for (Element e : elements) {
            traverse(e, tabCount + 1);
        }
    }

    public int getLine() {
        return context.start.getLine();
    }

    public int getStart() {
        return context.start.getStartIndex();
    }

    public int getStop() {
        return context.start.getStopIndex();
    }

    /*https://www.mkyong.com/java/java-how-to-overrides-equals-and-hashcode/*/
    @Override
    public int hashCode() {
        return Objects.hash(this.getContext().getText());
    }

    @Override
    public boolean equals(java.lang.Object obj) {
        return obj == this || obj instanceof Element && this.getUniqueName().equals(((Element) obj).getUniqueName());
    }

    protected static String getNormalizedText(ParserRuleContext ctx) {
        return ctx.start.getInputStream().getText(new Interval(ctx.start.getStartIndex(), ctx.stop.getStopIndex()))
                .replaceAll("\\s+", " ").replaceAll("(\\w)(\\s)(<)", "$1$3");
    }

    protected static String getNormalizedText(final ParserRuleContext ctx, final int start, final int stop) {
        return ctx.start.getInputStream().getText(new Interval(start, stop))
                .replaceAll("\\s+", " ").replaceAll("(\\w)(\\s)(<)", "$1$3");
    }
}

