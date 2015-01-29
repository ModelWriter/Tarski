head	1.1;
access;
symbols;
locks; strict;
comment	@# @;


1.1
date	2010.03.02.22.30.41;	author tfaure;	state Exp;
branches;
next	;
commitid	73794b8d918e4567;


desc
@@


1.1
log
@first commit for doc2model api : documents
this plugin contains interface for IDocument and some utils classes to handle xmls, zip documents
@
text
@/**
 * Copyright (c) 2010 ATOS ORIGIN INTEGRATION.
 * 
 *     
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *   Tristan FAURE (ATOS ORIGIN INTEGRATION) tristan.faure@@atosorigin.com - Initial API and implementation
 */
package org.eclipse.emf.doc2model.documents.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.eclipse.emf.doc2model.documents.Logger;

public class Zipper {
	/** The Constant BUFFERVALUE. */
	private int BUFFERVALUE = 8192;

	/** The Constant BUFFER. */
	private byte[] BUFFER = new byte[BUFFERVALUE];

	private File file;

	public Zipper(File file) {
		this.file = file;
	}

	public void zip(String locationToZip) {
		if (file.isDirectory()) {
			try {
				ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(
						locationToZip));
				try {
					addFileToZip(zos, file.getPath(), locationToZip);
				} finally {
					zos.close();
				}
			} catch (FileNotFoundException fnfe) {
				Logger.INSTANCE.log(fnfe);
			} catch (IOException ioe) {
				Logger.INSTANCE.log(ioe);
			}
		}
	}

	/**
	 * Zip a folder representing an openDocument into an OpenDocument File.
	 * 
	 * @@param folderOpenDocument
	 *            the main folder containing the files found inside an
	 *            OpenDocument
	 * @@param extension
	 *            the extension of the OpenDocument (.odt, .odp...)
	 * 
	 * @@since 1.0.0
	 * @@version 1.0.0
	 */

	/**
	 * Adds the file to zip.
	 * 
	 * @@param zos
	 *            the zos
	 * @@param path
	 *            the path
	 * @@param zipPath
	 *            the zip path
	 * 
	 * @@since 1.0.0
	 * @@version 1.0.0
	 */
	private void addFileToZip(ZipOutputStream zos, String path, String zipPath) {
		File file = new File(path);
		if (file.isDirectory() && file.list().length != 0) {
			String[] files = file.list();
			for (String filePath : files) {
				addFileToZip(zos, path + File.separator + filePath, zipPath);
			}
		} else {
			try {
				String zipEntryLocation = getRelativePathInZip(file.getPath(),
						zipPath);
				if (file.isDirectory() && file.list().length == 0) {
					ZipEntry entry = new ZipEntry(zipEntryLocation + "/");
					zos.putNextEntry(entry);

				} else {
					FileInputStream in = new FileInputStream(file);
					try {
						ZipEntry zipEntry = new ZipEntry(zipEntryLocation);
						zos.putNextEntry(zipEntry);

						int bytesRead;
						while (-1 != (bytesRead = in.read(BUFFER))) {
							zos.write(BUFFER, 0, bytesRead);
						}
					} finally {
						// Close the FileInputStream
						in.close();
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}
		file.delete();
	}

	/**
	 * Gets the relative path of a file in a zip.
	 * 
	 * @@param filePath
	 *            the file path
	 * @@param zipPath
	 *            the zip path
	 * 
	 * @@return the relative path of a file in a zip.
	 * 
	 * @@since 1.0.0
	 * @@version 1.0.0
	 */
	private String getRelativePathInZip(String filePath, String zipPath) {
		// Remove the path of the Zip file
		String relativePath = filePath.substring(file.getAbsolutePath()
				.length() + 1);
		// Replace \ by / otherwise Zip is corrupted.
		relativePath = relativePath.replace("\\", "/");
		return relativePath;
	}

}
@
