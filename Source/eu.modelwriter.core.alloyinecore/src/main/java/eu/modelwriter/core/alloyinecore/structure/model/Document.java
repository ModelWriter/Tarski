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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import eu.modelwriter.core.alloyinecore.structure.base.Object;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.*;

public class Document {

    private Map<String, Object> eContentQName = new HashMap<>();
    private List<Object> eContent = new ArrayList<>();
    private Map<String, Package> ePackage = new HashMap<>();
    private Map<String, Import> ePackageImports = new HashMap<>();
    private final AlloyInEcoreParser parser;

    public Document(AlloyInEcoreParser parser) {
        this.parser = parser;
    }

    protected static EObject getElement(EObject root, final List<String> relativePathFragments) {
        return relativePathFragments.size() == 0 ? root : EcoreUtil.getEObject(root, String.join("/", relativePathFragments));
    }

//    public static EObject getEObject(final Stack<String> qualifiedName) {
//        final List<String> relativePathFragments = qualifiedName.stream().collect(Collectors.toList());
//        relativePathFragments.remove(0);
//
//        final String packageName = qualifiedName.get(0);
//        final Module module = Repository.name2Module.get(packageName);
//        return module.getElement(relativePathFragments);
//    }
//
//    public static EObject getEObject(final String moduleName, final List<String> relativePathFragments) {
//        final Module module = Repository.name2Module.get(moduleName);
//        return module.getElement(relativePathFragments);
//    }

    protected void addEObject(Object eObject) {
        eContent.add(eObject);
    }

    public void checkConstraints(){
        for(int i = eContent.size()-1; i >= 0; i--){
            addEObjectToQNameMap(eContent.get(i));
        }
    }

    private void addEObjectToQNameMap(Object eObject){
//        String uniqueName = eObject.getUniqueName();
//        if (uniqueName == null || uniqueName.isEmpty()) {
//            parser.notifyErrorListeners(eObject.getContext().start, "A uniqueName could not be calculated for this element.", null);
//        } else if (eContentQName.containsKey(uniqueName)) {
//            System.out.println(uniqueName);
//            parser.notifyErrorListeners(eObject.getToken(), "1. Name collision is detected, this symbol is omitted.", null);
//            parser.notifyErrorListeners(eContentQName.get(uniqueName).getToken(), "2. Name collision is detected, this symbol is resolved.", null);
//        } else {
//            if (eObject instanceof Package) {
//                ePackage.put(uniqueName, (Package) eObject);
//            } else (eObject instanceof Import) {
//                ePackageImports.put(uniqueName, (Import) eObject);
//            }
//            eContentQName.put(uniqueName, eObject);
//        }
    }
}
