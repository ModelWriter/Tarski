package org.eclipse.emf.doc2model.documents.zip;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.eclipse.core.runtime.Path;
import org.eclipse.emf.doc2model.documents.Documents;

/**
 * The Class Unzipper.
 * 
 * @author tristan.faure@atosorigin.com
 */
public class Unzipper {

	/** The in file name. */
	private File inFileName;

	/** The path. */
	private String path = Documents.getDefault().getStateLocation()
			+ File.separator + "unzipped" + File.separator;

	/** The files. */
	private HashMap<String, File> files = new HashMap<String, File>();

	/**
	 * Instantiates a new unzipper.
	 * 
	 * @param file
	 *            the file
	 */
	public Unzipper(File file) {
		inFileName = file;
		path += file.getName();
	}

	public Unzipper(File file, String thepath) {
		inFileName = file;
		path = thepath;
	}

	/**
	 * Unzip.
	 */
	public void unzip() {
		// The location to unzip the file
		String locationToUnzip = path;

		try {
			ZipInputStream zis = new ZipInputStream(new FileInputStream(
					inFileName.getPath()));

			ZipEntry zipEntry = zis.getNextEntry();
			while (zipEntry != null) {
				File file = new File(locationToUnzip, zipEntry.getName());
				if (zipEntry.isDirectory()) {
					file.mkdirs();
				} else {
					file.getParentFile().mkdirs();
					final OutputStream fos = new BufferedOutputStream(
							new FileOutputStream(file));

					try {
						final byte[] buf = new byte[2048];
						int bytesRead;
						while (-1 != (bytesRead = zis.read(buf))) {
							fos.write(buf, 0, bytesRead);
						}

					} catch (final IOException ioe) {
						throw new IllegalArgumentException(String.format(
								"can't open %s", inFileName.getName()));
					} finally {
						fos.close();
					}

					if (file.length() == 0
							&& Path.fromOSString(file.getAbsolutePath())
									.getFileExtension().length() == 0) {
						String pathFile = file.getAbsolutePath();
						file.delete();
						new File(pathFile).mkdir();

					} else {
						files.put(file.getName(), file);
					}

				}
				zipEntry = zis.getNextEntry();
			}
			zis.close();

		} catch (IOException ioe) {
			throw new IllegalArgumentException(String.format("can't open %s",
					inFileName.getName()));
		}
	}

	/**
	 * Clean.
	 */
	public void clean() {
		File f = new Path(path).toFile();
		clean(f);
	}

	/**
	 * Clean.
	 * 
	 * @param f
	 *            the f
	 */
	private void clean(File f) {
		File[] thefiles = f.listFiles();
		for (File f2 : thefiles) {
			if (f2.isDirectory()) {
				clean(f2);
			} else {
				f2.deleteOnExit();
			}
		}
		f.deleteOnExit();
	}

	/**
	 * Gets the file.
	 * 
	 * @param name
	 *            the name
	 * 
	 * @return the file
	 */
	public File getFile(String name) {
		File result = files.get(name);
		if (result == null) {
			for (File f : files.values()) {
				String pattern = "";
				if (File.separator.contains("\\")) {
					pattern = "\\";
				}
				if (name.contains("..")) {
					name = name.replace(".", "");
				}
				if (f.getAbsolutePath().replaceAll(pattern + File.separator,
						"/").contains(name)) {
					result = f;
					break;
				}
			}
		}
		return result;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	static void main(String[] args) {
		new Unzipper(new File("toto")).unzip();
	}

	public File getDocumentFile() {
		return inFileName;
	}

	public File getUnzipDocumentFile() {
		return new Path(path).toFile();
	}
}
