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
    private Map<String, NamedElement> elements = new HashMap<>();
    private Package documentRoot = null;
    public final Stack<NamedElement> ownershipStack = new Stack<>();

    public AlloyInEcoreParser parser = null;

    public boolean isParsingCompleted() {
        return parsingCompleted;
    }

    public void singalParsingCompletion() {

        for (String k : elements.keySet()) {
            System.out.println(elements.get(k));
        }
        this.parsingCompleted = true;
        for (Type type : types) {
            System.out.println(type);
            type.match();
        }
    }

    public void addType(Type t){
        types.add(t);
    }

    private boolean parsingCompleted = false;

    private Package getDocumentRoot() {
        return documentRoot;
    }
    private void setDocumentRoot(Package documentRoot) {
        this.documentRoot = documentRoot;
    }

    public NamedElement getElement (String qualifiedName){
        return elements.get(qualifiedName);
    }
    public void addElement(NamedElement element){
        if (element instanceof Classifier)
            elements.put(Document.getQualifiedName((Classifier) element), element);
        else if (element instanceof Package)
            elements.put(Document.getQualifiedName((Package)element), element);
        else if (element instanceof StructuralFeature)
            elements.put(Document.getQualifiedName((StructuralFeature)element), element);
        else if (element instanceof EnumLiteral)
            elements.put(Document.getQualifiedName((EnumLiteral)element), element);
        else if (element instanceof Operation)
            elements.put(Document.getQualifiedName((Operation)element), element);
        else if (element instanceof Parameter)
            elements.put(Document.getQualifiedName((Parameter)element), element);
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

    public static Package create(EPackageContext context){
        Package p = new Package(context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            p.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        p.nsURI = context.nsURI.getText();
        p.nsPrefix = context.nsPrefix.getText();
        p.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek());
        if (Document.getInstance().getDocumentRoot() == null)
            Document.getInstance().setDocumentRoot(p);
        Document.getInstance().addElement(p);
        p.qualifiedName = Document.getQualifiedName(p);
        Document.getInstance().elements.put(p.qualifiedName, p);
        //System.out.println(a);
        return p;
    }

    public static Class create(EClassContext context){
        Class c = new Class (context.name.getText(), context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            c.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        if (context.isAbstract != null)
            c.isAbstract = true;
        if (context.isInterface!= null)
            c.isInterface = true;
        c.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek());
        c.qualifiedName = Document.getQualifiedName(c);
        Document.getInstance().elements.put(c.qualifiedName, c);
        //System.out.println(a);
        return c;
    }

    public static DataType create(EDataTypeContext context){
        DataType t = new DataType (context.name.getText(), context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            t.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        t.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        t.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek());
        Document.getInstance().addElement(t);
        t.qualifiedName = Document.getQualifiedName(t);
        Document.getInstance().elements.put(t.qualifiedName, t);
        //System.out.println(t);
        return t;
    }

    public static Enum create(EEnumContext context){
        Enum e = new Enum(context.name.getText(), context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            e.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        e.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        e.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Package) Document.getInstance().ownershipStack.peek());
        Document.getInstance().addElement(e);
        e.qualifiedName = Document.getQualifiedName(e);
        Document.getInstance().elements.put(e.qualifiedName, e);
        //System.out.println(e);
        return e;
    }

    public static EnumLiteral create(EEnumLiteralContext context){
        EnumLiteral e = new EnumLiteral (context.name.getText(), context);
        e.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Enum) Document.getInstance().ownershipStack.peek());
        e.qualifiedName = Document.getQualifiedName(e);
        if (context.value != null)
            try {
                e.value = Integer.valueOf(context.value.getText());
            } catch(NumberFormatException ex) { }
        Document.getInstance().addElement(e);
        Document.getInstance().elements.put(e.qualifiedName, e);
        //System.out.println(e);
        return e;
    }

    public static Attribute create(EAttributeContext context){
        Attribute a = new Attribute (context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            a.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        a.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        a.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek());
        Document.getInstance().addElement(a);
        a.qualifiedName = Document.getQualifiedName(a);
        Document.getInstance().elements.put(a.qualifiedName, a);
        //System.out.println(a);
        return a;
    }

    public static Reference create(EReferenceContext context){
        Reference r = new Reference (context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            r.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        r.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        r.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek());
        Document.getInstance().addElement(r);
        r.qualifiedName = Document.getQualifiedName(r);
        Document.getInstance().elements.put(r.qualifiedName, r);
        //System.out.println(r);
        return r;
    }

    public static Operation create(EOperationContext context){
        Operation o = new Operation (context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            o.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        o.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        o.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Class) Document.getInstance().ownershipStack.peek());
        Document.getInstance().addElement(o);
        o.qualifiedName = Document.getQualifiedName(o);
        Document.getInstance().elements.put(o.qualifiedName, o);
        //System.out.println(o);
        return o;
    }

    public static Parameter create(EParameterContext context){
        Parameter p = new Parameter (context.name.getText(), context);
        p.setOwner(Document.getInstance().ownershipStack.size() == 0 ? null : (Operation) Document.getInstance().ownershipStack.peek());
        p.setQualifiers(context.qualifier.stream()
                .map(Token::getText).distinct()
                .collect(Collectors.toList()));
        Document.getInstance().addElement(p);
        p.qualifiedName = Document.getQualifiedName(p);
        Document.getInstance().elements.put(p.qualifiedName, p);
        //System.out.println(p);
        return p;
    }


    public static String getQualifiedName(Package p) {
        return p.getOwner() == null ? p.getName() : getQualifiedName(p.getOwner()) + "." + p.getName();
    }

    public static String getQualifiedName(Classifier c) {
        return c.getOwner() == null ? c.getName() : getQualifiedName(c.getOwner()) + "." + c.getName();
    }

    public static String getQualifiedName(StructuralFeature f) {
        return getQualifiedName(f.getOwner()) + "::" + f.getName();
    }

    public static String getQualifiedName(Operation o) {
        return getQualifiedName(o.getOwner()) + "->" + o.getName();
    }

    public static String getQualifiedName(EnumLiteral l) {
        return getQualifiedName(l.getOwner()) + "::" + l.getName();
    }

    public static String getQualifiedName(Parameter p) {
        return getQualifiedName(p.getOwner()) + "::" + p.getName();
    }

}
