package org.eclipse.emf.doc2model.documents.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.doc2model.documents.DocumentFactory;

public class DocumentsUtil {

	private static String extensionPointIdFactory = "org.eclipse.emf.doc2model.documents.factory";
	private static List<DocumentFactory> factories = null;

	/**
	 * Analyse string in parameter and returns a factory ables to load the
	 * document
	 * 
	 * @param path
	 * @return the document factory
	 */
	public static DocumentFactory getFactory(String path) {
		if (factories == null) {
			IConfigurationElement[] elements = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(extensionPointIdFactory);
			factories = new ArrayList<DocumentFactory>(elements.length);
			for (IConfigurationElement element : elements) {
				String clazz = element.getAttribute("class");
				Class<?> factory = null;
				try {

					factory = Class.forName(clazz);
				} catch (ClassNotFoundException e) {
					try {
						factory = Platform.getBundle(
								element.getContributor().getName()).loadClass(
								clazz);
					} catch (InvalidRegistryObjectException e1) {
					} catch (ClassNotFoundException e1) {
					}
				}
				if (factory != null) {
					DocumentFactory docFactory;
					try {
						docFactory = (DocumentFactory) factory.newInstance();
						factories.add(docFactory);
					} catch (InstantiationException e1) {
					} catch (IllegalAccessException e1) {
					}
				}
			}
		}
		for (DocumentFactory d : factories) {
			if (d.handles(path)) {
				return d;
			}
		}
		return null;
	}

}
