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

package eu.modelwriter.core.alloyinecore;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ModelIO<T extends EObject> {
    private ResourceSet resourceSet;

    /**
     * Gets first root EObject (index = 0) of given uri
     *
     * @param uri
     * @return root @EObject
     * @throws IOException
     */
    public static EObject getRootObject(final URI uri) throws IOException {
        final List<EObject> models = loadMetaModel(uri);
        return models == null ? null : models.get(0);
    }

    /**
     * Loads EMF Metamodel via given @URI
     *
     * @param uri Metamodel's @URI
     * @return List of @EModelElement
     * @throws IOException
     */
    public static List<EObject> loadMetaModel(final URI uri) throws IOException {
        List<EObject> list;
        try {
            final ModelIO<EObject> modelIO = new ModelIO<>();
            list = modelIO.getEObjects(uri);
        } catch (final Exception e) {
            return null;
        }
        return list;
    }

    /**
     * Gets first root EObject (index = 0) of any given path
     *
     * @param anyPath
     * @return root @EObject
     * @throws IOException
     */
    public static EObject getRootObject(final String anyPath) throws IOException {
        final List<EObject> eObjects = loadMetaModel(anyPath);
        return eObjects != null ? eObjects.get(0) : null;
    }

    /**
     * Loads EMF Metamodel via given path
     *
     * @param anyPath
     * @return root @EObject
     * @throws IOException
     */
    public static List<EObject> loadMetaModel(final String anyPath) throws IOException {
        List<EObject> eObjects = loadMetaModel(URI.createPlatformResourceURI(anyPath, true));

        if (eObjects == null) {
            eObjects = loadMetaModel(URI.createFileURI(anyPath));
            if (eObjects == null) {
                eObjects = loadMetaModel(URI.createPlatformPluginURI(anyPath, true));
                if (eObjects == null) {
                    eObjects = loadMetaModel(URI.createURI(anyPath));
                }
            }
        }
        return eObjects;
    }

    public ResourceSet getResourceSet() {
        if (this.resourceSet == null) {
            this.resourceSet = new ResourceSetImpl();
            this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                    .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new EcoreResourceFactoryImpl());
            this.registerPackages(this.resourceSet.getPackageRegistry());
        }

        return this.resourceSet;
    }

    public List<EObject> getEObjects(final URI uri) throws IOException {
        final Resource resource = this.getResourceSet().createResource(uri);
        try {
            resource.load(null);
        } catch (final IOException e) {
            throw new IOException();
        }
        return resource.getContents();
    }

    /**
     * ResourceSet'e paket kayit eder.
     * <p>
     * <br>
     * <br>
     * Ornegin; <br>
     * <code>packageRegistry.put(ContentPackage.eNS_URI, ContentPackage.eINSTANCE);</code> <br>
     * <br>
     * Kendi modellerinizi kullanacaksaniz bu methodu gerceklestiriniz ve kendi paket arayuzunuzu
     * kayit ediniz. EMF metamodelleri kullanacaksaniz varsayilan gerceklestirim yeterlidir.
     *
     * @param packageRegistry ResourceSet'a ait paket kayitcisi.
     */
    protected void registerPackages(final EPackage.Registry packageRegistry) {
    }

    public void write(final URI uri, final T obj) {
        final Resource resource = this.getResourceSet().createResource(uri);

        resource.getContents().add(obj);

        final HashMap<Object, Object> options = new HashMap<>();
        try {
            resource.save(options);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
