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
package eu.modelwriter.architecture.textconnectors.docx.genparser.command.ui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import DocModel.Document;
import DocModel.presentation.DocModelObserver;

import com.modelwriter.architecture.textconnectors.docx.genparser.Doc2ParseModel;
import com.modelwriter.architecture.textconnectors.docx.genparser.MyContentAdapter;
import com.modelwriter.architecture.textconnectors.docx.genparser.notifymanager.MappingManager;


public class Convert2DocModelHandler extends AbstractHandler implements
IHandler {

	private static DocModelObserver observer;
	private static MyContentAdapter observerMy;
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

		MappingManager map = MappingManager.getInstance();
		XWPFDocument document = null;

		Shell shell = HandlerUtil.getActiveShell(event);
		ISelection sel = HandlerUtil.getActiveMenuSelection(event);
		IStructuredSelection selection = (IStructuredSelection) sel;


		Object firstElement = selection.getFirstElement();

		if(firstElement instanceof IResource){

			IResource iresource = (IResource) Platform.getAdapterManager().getAdapter(firstElement, IResource.class);

			if (iresource == null) {
				if (firstElement instanceof IAdaptable) {
					iresource = (IFile) ((IAdaptable) firstElement).getAdapter(IResource.class);
				}
			}

			if (iresource != null) {

				if(!iresource.getName().contains(".docmodel")){

					final JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "WRONG FILE TYPE! (expected type: .reqmodel)");

				}else{


					// GETTING DOCMODEL RESOURCE
					String locationString = iresource.getLocation().toString();
					String loc = "file:///" + locationString;

					URI uri = URI.createURI(loc);

					ResourceSet resourceSet = new ResourceSetImpl();

					// register UML
					Map packageRegistry = resourceSet.getPackageRegistry();
					packageRegistry.put(DocModel.DocModelPackage.eNS_URI, 
							DocModel.DocModelPackage.eINSTANCE);

					// Register XML resource as UMLResource.Factory.Instance
					Map extensionFactoryMap = Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap();
					extensionFactoryMap.put("xmi", new XMIResourceFactoryImpl());


					// Getting docx file from file dialog
					FileDialog fsd = new FileDialog(shell);
					fsd.setFilterExtensions(new String[] {"*.docx"});
					fsd.setText("Select A Docx File...");
					fsd.open();

					String fileName = fsd.getFileName();
					String path = fsd.getFilterPath();
					//TODO path'i set et doc object için
					File docxFile = new File(path + "\\" + fileName);
					String absolutePath = docxFile.getAbsolutePath();
					map.setDocumentPath(absolutePath);
					
					try {
						document = new XWPFDocument(new FileInputStream(docxFile.getAbsoluteFile()));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}					

					try {

						Resource r = resourceSet.createResource(uri);
						
							Document d = (Document) Doc2ParseModel.parse(document,r,null).getContents().get(0);
							r.getContents().add(d);
							r.getContents().remove(0);
							r.save(null);			

					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}


			}


		}
		return null;

	}

	/**
	 * Gets the .docx file and converts it to .docmodel
	 * 
	 * @param Document document
	 * @param String location
	 */
	private static void createXMIFile(Document document, String location) {

		ResourceSet resourceSet = new ResourceSetImpl();

		// Register XML Factory implementation using xmi extension
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				"xmi", new  XMLResourceFactoryImpl());


		// Create empty resource with the given URI
		Resource resource = resourceSet.createResource(URI.createURI(location));


		// Add Product to contents list of the resource 

		resource.getContents().add(document);

		try{

			// Save the resource
			//resource.save(System.out, Collections.EMPTY_MAP); 
			resource.save(null);
			final JFrame frame = new JFrame();
			JOptionPane.showMessageDialog(frame, "Document Model was created successfully!");

		}catch (IOException e) {

			e.printStackTrace();
		}



	}

}
