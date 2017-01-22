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

import eu.modelwriter.core.alloyinecore.recognizer.AlloyInEcoreParser;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Document {

    private static Document INSTANCE = new Document();
    private Map<String, Object> eContent = new HashMap<>();
    private AlloyInEcoreParser parser;

    private Document() {
    }

    public Document(AlloyInEcoreParser parser) {
        this.parser = parser;
    }

    public static Document getInstance() {
        return INSTANCE;
    }

    protected static EObject getElement(EObject root, final List<String> relativePathFragments) {
        return relativePathFragments.size() == 0 ? root
                : EcoreUtil.getEObject(root, String.join("/", relativePathFragments));
    }

    public void setParser(AlloyInEcoreParser parser) {
        this.parser = parser;
    }

    protected void addEObject(Object eObject) {
        String uniqueName = eObject.getUniqueName();
        if (uniqueName == null || uniqueName.isEmpty()) {
            parser.notifyErrorListeners(eObject.getContext().start, "A uniqueName could not be calculated for this element.", null);
        } else if (eContent.containsKey(uniqueName)) {
            System.out.println(uniqueName);
            parser.notifyErrorListeners(eObject.getToken(), "1. Name collision is detected, this symbol is omitted.", null);
            parser.notifyErrorListeners(eContent.get(uniqueName).getToken(), "2. Name collision is detected, this symbol is resolved.", null);
        } else {
            eContent.put(uniqueName, eObject);
        }
    }
}
