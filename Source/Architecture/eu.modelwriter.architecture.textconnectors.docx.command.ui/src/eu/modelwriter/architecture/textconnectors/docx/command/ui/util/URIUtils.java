/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package eu.modelwriter.architecture.textconnectors.docx.command.ui.util;

import java.io.File;
import java.io.FileFilter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;

public final class URIUtils {

	/**
	 * Constructor
	 */
	private URIUtils() {
		// hidden, since this class only provides static helper methods
	}

	/**
	 * Convert EMF URI to Eclipse file
	 */
	public static IFile getFile(URI uri) {
		String platformString = uri.toPlatformString(true);
		if (platformString != null) {
			Path path = new Path(platformString);
			return ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		}
		return null;
	}

	/**
	 * Convert EMF URI to Eclipse folder
	 */
	public static IFolder getFolder(URI uri) {
		Path path = new Path(uri.toPlatformString(true));
		return ResourcesPlugin.getWorkspace().getRoot().getFolder(path);
	}

	/**
	 * Convert Eclipse resource to EMF URI
	 */
	public static URI getURI(IResource file) {
		return getURI(file.getFullPath());
	}
	

	/**
	 * Create an EMF URI from an Eclipse path
	 */
	public static URI getURI(IPath path) {
		return URI.createPlatformResourceURI(path.toString(), true);
	}

	/**
	 * Convert a file name to an EMF URI
	 *
	 * @param fileName
	 * @return EMF URI
	 */
	public static URI getURI(String fileName) {
		return getURI(new File(fileName));
	}

	/**
	 * Convert a file name to an EMF URI
	 *
	 * @param file
	 * @return EMF URI
	 */
	public static URI getURI(File file) {
		return URI.createFileURI(file.getAbsolutePath());
	}

	/**
	 * Get Java URL from EMF URI
	 *
	 * @param uri
	 *            EMF URI
	 * @return Java URL
	 */
	public static URL getURL(URI uri) {
		try {
			URL url = new URL(uri.toString());
			return url;
		} catch (MalformedURLException e) {
			return null;
		}
	}

	/**
	 * Get EMF URI from Java URL
	 *
	 * @param url
	 *            Java URL
	 * @return EMF URI
	 */
	public static URI getURI(URL url) {
		return URI.createURI(url.toString());
	}

	/**
	 * Replace extension of a file
	 *
	 * @param file
	 *            File
	 * @param ext
	 *            New extension
	 * @return New file
	 */
	public static IFile replaceExtension(IFile file, String ext) {
		IProject project = file.getProject();
		return project.getFile(file.getProjectRelativePath()
				.removeFileExtension().addFileExtension(ext));
	}

	/**
	 * Replace extension of a EMF URI
	 *
	 * @param uri
	 *            EMF URI
	 * @param ext
	 *            New extension
	 * @return New EMF URI
	 */
	public static URI replaceExtension(URI uri, String ext) {
		return uri.trimFileExtension().appendFileExtension(ext);
	}

	/**
	 * Get the Java file for a URI
	 *
	 * @param uri
	 * @return Java file
	 */
	public static File getJavaFile(URI uri) {
		if (uri.isPlatform()) {
			IFile file = getFile(uri);
			IPath location = file.getLocation();
			return location.toFile();
		}
		return new File(uri.toFileString());
	}

	/** Get the relative path of a {@link URI} w.r.t. another {@link URI}. */
	public static URI getRelativePath(URI uri, URI relativeTo) {
		return uri.deresolve(relativeTo, true, true, true);
	}

	public static List<URI> listURIs(String folderPath) {
		return listURIs(folderPath, null);
	}

	public static List<URI> listURIs(String folderPath, String suffix) {
		if (folderPath == null || folderPath.isEmpty()) {
			throw new RuntimeException("folderPath null ya da empty.");
		}

		File folder = new File(folderPath);

		if (!folder.isDirectory()) {
			throw new RuntimeException(String.format("'%s' klasor degil.",
					folderPath));
		}

		List<URI> uriList = new ArrayList<>();
		File[] files = folder.listFiles(new DosyaFilter(suffix));
		for (File file : files) {
			uriList.add(URI.createFileURI(file.toString()));
		}

		return uriList;
	}
}

class DosyaFilter implements FileFilter {
	private String suffix;

	public DosyaFilter(String suffix) {
		this.suffix = suffix;
	}

	@Override
	public boolean accept(File pathname) {
		if (suffix == null || suffix.trim().isEmpty()) {
			return true;
		}

		return pathname.toString().endsWith(suffix);
	}
}

