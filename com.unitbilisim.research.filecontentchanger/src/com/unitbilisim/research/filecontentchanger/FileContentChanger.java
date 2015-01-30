

/**
 * This program trims redundant content from files
 * 
 * @author furkan.tanriverdi@unitbilisim.com
 * 
 */


package com.unitbilisim.research.filecontentchanger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileContentChanger {

	private final static String EXTENSION_CLASSPATH = "classpath";
	private final static String EXTENSION_PROJECT = "project";
	private final static String EXTENSION_XML = "xml";
	// plugin.properties
	// build.properties must be done by manually
	private final static String EXTENSION_PROPERTIES = "properties";
	private final static String EXTENSION_PREFS = "prefs";
	private final static String EXTENSION_MF = "MF";
	private final static String EXTENSION_JAVA = "java";
	private final static String EXTENSION_EXSD = "exsd";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File[] files = new File("C:/Users/2/Desktop/doc2model/doc2model/source/plugins").listFiles();
		showFiles(files);
	}

	
	public static void showFiles(File[] files) {

		for (File file : files) {

			if (file.isDirectory()) {
				//System.out.println("Directory: " + file.getName());
				showFiles(file.listFiles()); // Calls same method again.
			} else {

				String fileName = file.getName();
				//System.out.println("File: " + fileName);

				String[] values = fileName.split("\\.");

				String extension = values[(values.length)-1];
				//System.out.println("extension:" + extension);

				
				try {
					switch(extension){

					case EXTENSION_CLASSPATH : changeContent(file,"<?xml",">@"); break;         	

					case EXTENSION_EXSD : changeContent(file,"<?xml",">@"); break;

					case EXTENSION_JAVA : changeContent(file,"package","}@"); break;            

					case EXTENSION_MF : changeContent(file,"Manifest","@"); break;

					case EXTENSION_PREFS : changeContent(file,"eclipse.","@"); break;

					case EXTENSION_PROJECT : changeContent(file,"<?xml",">@"); break;

					// handles only plugin.properties
					case EXTENSION_PROPERTIES : changeContent(file,"plugin","@"); break;

					case EXTENSION_XML : changeContent(file,"<?xml",">@"); break;

					}// end switch
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}// end else

		}// end for

	}// end showFiles

	public static void changeContent(File file, String start, String end) throws IOException{

		//File tempFile = new File("temp" + file.getName());
		File tempFile = new File(file.getAbsolutePath() + ".tmp");
		BufferedReader reader = new BufferedReader(new FileReader(file));		
		PrintWriter writer = new PrintWriter(new FileWriter(tempFile));
		
		String currentLine;
		
		while((currentLine = reader.readLine()) != null) {
			/*
			// trim newline when comparing with lineToRemove
		    String trimmedLine = currentLine.trim();
		    if(trimmedLine.equals(lineToRemove)) continue;
		    writer.write(currentLine + System.getProperty("line.separator"));
			 */
			
			if(currentLine.contains(start)){
				
				if(currentLine.contains("@")){
					
					currentLine = currentLine.replaceAll("@", "");
					writer.println(currentLine);
				}
				else{
					writer.println(currentLine);

				}
				
				currentLine = reader.readLine();
				while(currentLine != null){
					
					if(currentLine.trim().equals("}")){
						
						writer.println(currentLine);
						currentLine = reader.readLine();
						
						if(currentLine != null){
							
							while(currentLine.equals("") ){
								writer.println(currentLine);
								currentLine = reader.readLine();
							}
							
							if(currentLine != null){
								
								if(currentLine.trim().contains("@@")){
									
									currentLine = currentLine.replaceAll("@@", "@");
									
								}else if(currentLine.trim().contains("@")){
									
									break;
								}
							}
						}
						
							
					}else if(currentLine.equals("@")){
						break;
					}else if(currentLine.trim().contains("@@")){
						currentLine = currentLine.replaceAll("@@", "@");
						writer.println(currentLine);
						currentLine = reader.readLine();
					}
					else{
						

						writer.println(currentLine);
						currentLine = reader.readLine();
					}
					
				}// end while
			}
			
		}// end while
		
		writer.close(); 
		reader.close(); 
		
		
		//Delete the original file
	      if (!file.delete()) {
	        System.out.println("Could not delete file");
	        return;
	      }

	      //Rename the new file to the filename the original file had.
	      if (!tempFile.renameTo(file))
	        System.out.println("Could not rename file");
		
	}

}
