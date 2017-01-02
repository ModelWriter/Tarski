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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EParameterContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EOperationContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumLiteralContext;
import org.antlr.v4.runtime.Token;

import java.util.*;
import java.util.stream.Collectors;

public class Document{

    private List<Type> types = new ArrayList<>();
    private List<Type> opposites = new ArrayList<>();
    private List<Type> superTypes = new ArrayList<>();
    private Map<String, NamedElement> elements = new HashMap<>();
    private Package documentRoot = null;
    public final Stack<NamedElement> ownershipStack = new Stack<>();

    public AlloyInEcoreParser parser = null;

    public void signalParsingCompletion() {
        System.out.println("[NamedElement]");
        for (String k : elements.keySet()) {
            System.out.println(elements.get(k));
        }

        for (Type type : types) {
            type.match();
        }
        System.out.println("[EType]");
        for (Type type : types) {
            System.out.println(type);
        }

        for (Type type : superTypes) {
            type.match();
        }
        System.out.println("[ESuperType]");
        for (Type type : superTypes) {
            System.out.println(type);
        }

        for (Type type : opposites) {
            type.match();
        }
        System.out.println("[EOpposite]");
        for (Type type : opposites) {
            System.out.println(type);
        }
    }

    Package getDocumentRoot() {
        return documentRoot;
    }

    void addType(Type t){
        if (t instanceof Opposite)
            opposites.add(t);
        else {
            types.add(t);
        }
    }

    NamedElement getElement(String qualifiedName){
        return elements.get(qualifiedName);
    }

    private void addElement(NamedElement element){
        if (element instanceof Classifier) {
            element.qualifiedName = Document.getQualifiedName((Classifier) element);
        } else if (element instanceof Package) {
            element.qualifiedName = Document.getQualifiedName((Package) element);
            if (documentRoot == null)
                documentRoot = (Package) element;
        } else if (element instanceof StructuralFeature) {
            element.qualifiedName = Document.getQualifiedName((StructuralFeature) element);
        } else if (element instanceof EnumLiteral) {
            element.qualifiedName = Document.getQualifiedName((EnumLiteral) element);
        } else if (element instanceof Operation) {
            element.qualifiedName = Document.getQualifiedName((Operation) element);
        } else if (element instanceof Parameter)
            element.qualifiedName = Document.getQualifiedName((Parameter) element);

        if (!elements.keySet().contains(element.qualifiedName)) {
            elements.put(element.qualifiedName, element);
        }else {
            NamedElement e = elements.get(element.qualifiedName);
            parser.notifyErrorListeners(element.getToken(), "The name of this element collides with " + e.qualifiedName, null);
        }
    }

    private static Document INSTANCE = new Document();
    public static Document getInstance() {
        return INSTANCE;
    }

    private Document() {
        this.addElement(new DataType("Integer"));
        this.addElement(new DataType("String"));
        this.addElement(new DataType("Boolean"));
        this.addElement(new DataType("BigInteger"));
        this.addElement(new DataType("UnlimitedNatural"));
        this.addElement(new DataType("ecore.EDate"));
        //....
    }

    public static Attribute create(EAttributeContext context){
        Class owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek();
        Attribute a = new Attribute (context.name.getText(), owner, context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            a.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        a.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        a.qualifiedName = Document.getQualifiedName(a);
        //System.out.println(a);
        return a;
    }

    public static Class create(EClassContext context){
        Package owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek();
        Class c = new Class (context.name.getText(), owner, context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            c.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        if (context.isAbstract != null)
            c.isAbstract = true;
        if (context.isInterface!= null)
            c.isInterface = true;
        c.qualifiedName = Document.getQualifiedName(c);
        Document.getInstance().addElement(c);
        //System.out.println(a);
        return c;
    }

    public static DataType create(EDataTypeContext context){
        Package owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek();
        DataType t = new DataType (context.name.getText(), owner, context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            t.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        t.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        t.qualifiedName = Document.getQualifiedName(t);
        Document.getInstance().addElement(t);
        //System.out.println(t);
        return t;
    }

    public static Enum create(EEnumContext context){
        Package owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek();
        Enum e = new Enum(context.name.getText(), owner, context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            e.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        e.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        e.qualifiedName = Document.getQualifiedName(e);
        Document.getInstance().addElement(e);
        //System.out.println(e);
        return e;
    }

    public static EnumLiteral create(EEnumLiteralContext context){
        Enum owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Enum) Document.getInstance().ownershipStack.peek();
        EnumLiteral e = new EnumLiteral (context.name.getText(), owner, context);
        if (context.value != null)
            try {
                e.value = Integer.valueOf(context.value.getText());
            } catch(NumberFormatException ignored) { }
        e.qualifiedName = Document.getQualifiedName(e);
        Document.getInstance().addElement(e);
        /* System.out.println(e); */
        return e;
    }

    public static Operation create(EOperationContext context){
        Class owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek();
        Operation o = new Operation (context.name.getText(), owner, context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            o.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        o.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        o.qualifiedName = Document.getQualifiedName(o);
        Document.getInstance().addElement(o);
        //System.out.println(o);
        return o;
    }

    public static Package create(EPackageContext context){
        Package owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek();
        Package p = new Package(context.name.getText(), owner, context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            p.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        p.nsURI = context.nsURI.getText();
        p.nsPrefix = context.nsPrefix.getText();
        p.qualifiedName = Document.getQualifiedName(p);
        Document.getInstance().addElement(p);
        //System.out.println(a);
        return p;
    }

    public static Parameter create(EParameterContext context){
        Operation owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Operation) Document.getInstance().ownershipStack.peek();
        Parameter p = new Parameter (context.name.getText(), owner, context);
        p.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        p.qualifiedName = Document.getQualifiedName(p);
        Document.getInstance().addElement(p);
        //System.out.println(p);
        return p;
    }

    public static Reference create(EReferenceContext context){
        Class owner = Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek();
        Reference r = new Reference (context.name.getText(), owner, context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            r.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        r.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        r.qualifiedName = Document.getQualifiedName(r);
        Document.getInstance().addElement(r);
        //System.out.println(r);
        return r;
    }

    static String getQualifiedName(Package p) {
        return p.getOwner() == null ? p.getName() : getQualifiedName(p.getOwner()) + "." + p.getName();
    }

    static String getQualifiedName(Classifier c) {
        return c.getOwner() == null ? c.getName() : getQualifiedName(c.getOwner()) + "." + c.getName();
    }

    static String getQualifiedName(StructuralFeature f) {
        return getQualifiedName(f.getOwner()) + "::" + f.getName();
    }

    static String getQualifiedName(Operation o) {
        return getQualifiedName(o.getOwner()) + "->" + o.getName();
    }

    static String getQualifiedName(EnumLiteral l) {
        return getQualifiedName(l.getOwner()) + "::" + l.getName();
    }

    static String getQualifiedName(Parameter p) {
        return getQualifiedName(p.getOwner()) + "::" + p.getName();
    }

}
