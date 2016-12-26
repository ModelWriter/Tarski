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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EPackageContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EAttributeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EClassContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EReferenceContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EDataTypeContext;
import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser.EEnumContext;
import org.antlr.v4.runtime.Token;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Document{

    public boolean isParsingCompleted() {
        return parsingCompleted;
    }

    private boolean parsingCompleted = false;

    public final Stack<Package> packageStack = new Stack<>();
    public final Stack<Classifier> classifierStack = new Stack<>();

    private Map<String, String> referenceTable = new HashMap<>();
    private Map<String, NamedElement> elements = new HashMap<>();
    private Map<String, Class> classes = new HashMap<>();
    private Map<String, DataType> dataTypes = new HashMap<>();

    private Package documentRoot = null;
    public Package getDocumentRoot() {
        return documentRoot;
    }
    public void setDocumentRoot(Package documentRoot) {
        this.documentRoot = documentRoot;
    }

    public void addSymbol(String fromQualifiedName, String toQualifiedName){
        referenceTable.put(fromQualifiedName, toQualifiedName);
    }
    public String getReference(String qualifiedName){
        return referenceTable.get(qualifiedName);
    }
    public Map<String, String> getAllReferences(){
        return referenceTable;
    }

    public NamedElement getElement (String qualifiedName){
        return elements.get(qualifiedName);
    }
    public void addElement(NamedElement element){
        if (element instanceof Classifier) {
            elements.put(Document.getQualifiedName((Classifier) element), element);
            if (element instanceof Class)
                classes.put(Document.getQualifiedName((Class) element), (Class)element);
            else if (element instanceof DataType)
                dataTypes.put(Document.getQualifiedName((DataType) element), (DataType) element);
        }
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

    public Class getClass (String qualifiedName){
        return classes.get(qualifiedName);
    }
    public DataType getDataType (String qualifiedName){
        return dataTypes.get(qualifiedName);
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
    }

    public static Package create(EPackageContext context){
        Package p = new Package(context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            p.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        p.nsURI = context.nsURI.getText();
        p.nsPrefix = context.nsPrefix.getText();
        p.setOwner(Document.getInstance().packageStack.size() == 0 ? null : Document.getInstance().packageStack.peek());
        if (Document.getInstance().getDocumentRoot() == null)
            Document.getInstance().setDocumentRoot(p);
        Document.getInstance().addElement(p);
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
        c.setOwner(Document.getInstance().packageStack.size() == 0 ? null : Document.getInstance().packageStack.peek());
        Document.getInstance().addElement(c);
        return c;
    }

    public static DataType create(EDataTypeContext context){
        DataType t = new DataType (context.name.getText(), context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            t.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        if (context.isPrimitive != null)
            t.isPrimitive = true;
        if (context.isSerializable != null)
            t.isSerializable = true;
        t.setOwner(Document.getInstance().packageStack.size() == 0 ? null : Document.getInstance().packageStack.peek());
        Document.getInstance().addElement(t);
        return t;
    }

    public static Enum create(EEnumContext context){
        Enum e = new Enum(context.name.getText(), context);
        if (context.visibility != null){
            String text = context.visibility.getText();
            e.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        if (context.isSerializable != null)
            e.isSerializable = true;
        e.setOwner(Document.getInstance().packageStack.size() == 0 ? null : Document.getInstance().packageStack.peek());
        Document.getInstance().addElement(e);
        return e;
    }

    public static Attribute create(EAttributeContext context){
        Attribute a = new Attribute (context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            a.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        for(Token t: context.qualifier){
            //System.out.println(t.getText());
        }
        a.setOwner(Document.getInstance().classifierStack.size() == 0 ? null : (eu.modelwriter.core.alloyinecore.structure.Class) Document.getInstance().classifierStack.peek());
        Document.getInstance().addElement(a);
        return a;
    }

    public static Reference create(EReferenceContext context){
        Reference r = new Reference (context.name.getText(), context);
        if (context.visibility != null) {
            String text = context.visibility.getText();
            r.visibility = Visibility.valueOf(text.toUpperCase(java.util.Locale.ENGLISH));
        }
        for(Token t: context.qualifier){
            //System.out.println(t.getText());
        }
        r.setOwner(Document.getInstance().classifierStack.size() == 0 ? null : (eu.modelwriter.core.alloyinecore.structure.Class) Document.getInstance().classifierStack.peek());
        Document.getInstance().addElement(r);
        return r;
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
