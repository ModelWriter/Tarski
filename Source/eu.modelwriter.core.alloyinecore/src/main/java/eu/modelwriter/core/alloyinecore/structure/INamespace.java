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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

import java.util.List;

public interface INamespace {

    String getKey();

    String getPath();

    EObject getEObject();

    default Resource getResource(){
        return getEObject().eResource();
    }

    default EObject getRootObject() {
        return getEObject().eContents().get(0);
    }

    default EObject getElement(final List<String> relativePathFragments) {
        EObject result;
        try {
            final String rootFragment = getResource().getURIFragment(getRootObject());
            relativePathFragments.add(0, rootFragment);
            result = getResource().getEObject(String.join("/", relativePathFragments));
            if (result == null) {
                throw new Exception();
            }
        } catch (final Exception e) {
            relativePathFragments.remove(0);
            result = getResource().getEObject(String.join("/", relativePathFragments));
        }
        return result;
    }
}
