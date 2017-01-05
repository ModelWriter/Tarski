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

import java.util.ArrayList;
import java.util.List;

public class Package extends NamedElement<EPackageContext>  {

    public Visibility visibility = Visibility.PACKAGE;
    public String nsURI;
    public String nsPrefix;
    private Package owner = null;
    public List<Package> ownedPackages = new ArrayList<>();
    public List<Classifier> ownedClassifiers = new ArrayList<>();

    public void setOwner(Package owner) {
        this.owner = owner;
    }

    public Package(String name, Package owner, EPackageContext context) {
        super(name, context);
        this.token = context.name.getStart();
        this.owner = owner;
        this.qualifiedName = Document.getQualifiedName(this);
    }

    public Classifier getClassifier (String name){
        return ownedClassifiers.stream().filter(q -> q.getName().equals(name)).findFirst().orElse(null);
    }

    @Override
    public Package getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Package{");
        sb.append("name=").append(qualifiedName);
        if (owner != null)
            sb.append(", owner=").append(owner.qualifiedName);
        sb.append(", visibility=").append(visibility);
        sb.append(", nsURI='").append(nsURI).append('\'');
        sb.append(", nsPrefix='").append(nsPrefix).append('\'');
        sb.append(", ownedPackages=").append(ownedPackages);
        sb.append(", ownedClassifiers=").append(ownedClassifiers);
        sb.append('}');
        return sb.toString();
    }
}
