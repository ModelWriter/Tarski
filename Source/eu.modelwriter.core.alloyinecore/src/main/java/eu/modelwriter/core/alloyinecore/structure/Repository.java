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

import eu.modelwriter.core.alloyinecore.internal.Console;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public final class Repository {
    public final Map<String, INamespace> name2Import;
    private ResourceSetImpl resourceSet;
    private Resource aieResource;

    /**
     * folder path segments of aieResource
     */
    private List<String> relativeComplementerSegments;
    /**
     * if load resource is called recursively to try to complete relative path, it is true. else it is
     * false.
     */
    private boolean isRelativePass = false;


    public Repository() {
        name2Import = new HashMap<>();
        resourceSet = new ResourceSetImpl();
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
    }

    public void printNamespaces(){
        System.out.println(Console.BOLD + "[NAMESPACES]" + Console.RESET);
        name2Import.values().forEach(anImport -> System.out.println(Console.CYAN + "[" + anImport.getKey() + "] " + Console.RESET + anImport.getEObject().toString() ));
    }

    public EObject loadAndClearAIEResource(final URI uri) {
        // try to get folder path of aieResource
        relativeComplementerSegments = new ArrayList<>(uri.segmentsList());
        relativeComplementerSegments.remove(relativeComplementerSegments.size() - 1);
        if (uri.scheme() != null && uri.scheme().equals("platform")) {
            relativeComplementerSegments.remove(0);
        }

        aieResource = resourceSet.createResource(uri);
        try {
            aieResource.load(null);
            EObject rootElement = null;
            if (!aieResource.getContents().isEmpty()) {
                rootElement = aieResource.getContents().get(0);
            }
            aieResource.getContents().clear();
            return rootElement;
        } catch (final IOException e) {
            return null;
        }
    }

    public Resource loadResource(String path) {
        while (path.startsWith("../") && relativeComplementerSegments.size() > 0) {
            // remove from path if starts with '../', and go up one directory
            path = path.substring(3, path.length());
            relativeComplementerSegments.remove(relativeComplementerSegments.size() - 1);
        }
        while (path.startsWith("./")) {
            // remove from path if starts with './'
            path = path.substring(2, path.length());
        }
        while (path.startsWith("/")) {
            // remove from path if starts with '/'
            path = path.substring(1, path.length());
        }

        Resource resource;
        try {
            // try to load with default URI
            resource = resourceSet.getResource(URI.createURI(path, true), true);
            if (resource.getContents().isEmpty()) {
                throw new Exception();
            }
            return resource;
        } catch (final Exception e1) {
            try {
                // try to load with platform resource URI
                resource = resourceSet.getResource(URI.createPlatformResourceURI(path, true), true);
                if (resource.getContents().isEmpty()) {
                    throw new Exception();
                }
                return resource;
            } catch (final Exception e2) {
                try {
                    // try to load with platform plugin URI
                    resource = resourceSet.getResource(URI.createPlatformPluginURI(path, true), true);
                    if (resource.getContents().isEmpty()) {
                        throw new Exception();
                    }
                    return resource;
                } catch (final Exception e3) {
                    try {
                        // try to load with file URI
                        resource = resourceSet.getResource(URI.createFileURI(path), true);
                        if (resource.getContents().isEmpty()) {
                            throw new Exception();
                        }
                        return resource;
                    } catch (final Exception e4) {
                        try {
                            // if any URI that created from path couldn't be loaded
                            // then we could think that is it relative path?
                            // so, add 'folder path of aieResource' to beginning of the 'path'
                            // and complete relative 'path' to full 'path'
                            final List<String> completedRelativePath =
                                    new ArrayList<>(relativeComplementerSegments);
                            completedRelativePath.add(path);
                            // now we have full 'path'
                            // we can try to load resource again.
                            if (!isRelativePass) {
                                isRelativePass = true;
                                resource = loadResource(String.join("/", completedRelativePath));
                                if (resource.getContents().isEmpty()) {
                                    throw new Exception();
                                }
                                isRelativePass = false;
                                return resource;
                            } else {
                                isRelativePass = false;
                                throw new Exception();
                            }
                        } catch (final Exception e5) {
                            // path could not be loaded anyway.
                            return null;
                        }
                    }
                }
            }
        }
    }

    public void saveResource(final EObject root, final URI saveURI) {
        final Resource resource = resourceSet.getResource(saveURI, true);
        resource.getContents().clear();
        resource.getContents().add(root);
        try {
            resource.save(null);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    public EObject getEObject(final Stack<String> qualifiedNameStack) {
        final List<String> relativePathFragments =
                qualifiedNameStack.stream().collect(Collectors.toList());
        relativePathFragments.remove(0);

        final String importName = qualifiedNameStack.get(0);
        final INamespace imported = name2Import.get(importName);
        return imported.getElement(relativePathFragments);
    }

    public EObject getEObject(final String importName, final List<String> relativePathFragments) {
        final INamespace aIEImport = name2Import.get(importName);
        return aIEImport.getElement(relativePathFragments);
    }

    public EPackage getRootPackage() {
        return (EPackage) aieResource.getContents().get(0);
    }
}
