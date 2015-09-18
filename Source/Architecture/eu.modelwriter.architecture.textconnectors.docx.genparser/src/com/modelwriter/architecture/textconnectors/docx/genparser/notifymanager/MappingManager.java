/*******************************************************************************
 * Copyright (c) 2015 UNIT Information Technologies R&D All rights reserved. This program and the
 * accompanying materials are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors: A. Furkan Tanriverdi (UNIT) - initial API and implementation
 *******************************************************************************/
package com.modelwriter.architecture.textconnectors.docx.genparser.notifymanager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import DocModel.Paragraph;


public class MappingManager {

  private static Map<String, List<XWPFRun>> map = new HashMap<String, List<XWPFRun>>();

  private static Map<String, XWPFParagraph> objectMap = new HashMap<String, XWPFParagraph>();

  private static Map<String, Paragraph> modelMap = new HashMap<String, Paragraph>();

  private static String documentPath = "";
  // Singleton
  private static MappingManager instance = null;
  private static XWPFDocument docInstance = null;

  public static MappingManager getInstance() {
    if (MappingManager.instance == null) {
      MappingManager.instance = new MappingManager();
    }
    return MappingManager.instance;
  }

  public static XWPFDocument getXWPFDocInstance() {

    return MappingManager.docInstance;
  }

  // public void changeNodeName(String id, String newOne) {
  // // UNIT 09/2015
  // XWPFParagraph p = MappingManager.objectMap.get(id);
  // Paragraph paragraph = MappingManager.modelMap.get(id);
  //
  // List<XWPFRun> runs = p.getRuns();
  // for (int i = runs.size() - 1; i > 0; i--) {
  // String runText = runs.get(i).toString();
  // String charhacter = String.valueOf(runText.charAt(runText.length() - 1));
  // if (charhacter.equals(":")
  // && runText.substring(0, runText.length() - 1).equals(paragraph.getName())) {
  // runs.get(i).setText(newOne + ":", 0);
  // break;
  // } else if (runText.equals(paragraph.getName())) {
  // runs.get(i).setText(newOne, 0);
  // }
  // }
  // paragraph.setName(newOne);
  //
  // MappingManager.map.put(id, p.getRuns());
  // int position = MappingManager.docInstance.getPosOfParagraph(p);
  // MappingManager.docInstance.setParagraph(p, position);
  // }

  public void changeParagraphName(String id, String newOne) {
    // UNIT 09/2015
    XWPFParagraph p = MappingManager.objectMap.get(id);
    Paragraph paragraph = MappingManager.modelMap.get(id);

    List<XWPFRun> runs = p.getRuns();
    for (int i = runs.size() - 1; i >= 0; i--) {
      String runText = runs.get(i).toString();
      String charhacter = String.valueOf(runText.charAt(runText.length() - 1));
      if (charhacter.equals(":")
          && runText.substring(0, runText.length() - 1).equals(paragraph.getName())) {
        runs.get(i).setText(newOne + ":", 0);
      } else if (runText.equals(paragraph.getName())) {
        runs.get(i).setText(newOne, 0);
      }
    }
    paragraph.setName(newOne);

    MappingManager.map.put(id, p.getRuns());
    int position = MappingManager.docInstance.getPosOfParagraph(p);
    MappingManager.docInstance.setParagraph(p, position);
  }

  private void delete(String id) {

    XWPFParagraph p = MappingManager.objectMap.get(id);
    int position = MappingManager.docInstance.getPosOfParagraph(p);
    MappingManager.docInstance.removeBodyElement(position);
    MappingManager.map.remove(id);
    MappingManager.objectMap.remove(id);
    MappingManager.modelMap.remove(id);
  }

  private void deleteContainments(Paragraph paragraph) {



    if (paragraph.getOwnedNode().size() > 0) {
      for (Paragraph para : paragraph.getOwnedNode()) {

        this.deleteContainments(para);
      }
    }

    this.delete(paragraph.getId());

  }

  /*
   * public void changePartName(String id, String newOne) {
   *
   * int i = 0; String s = "";
   *
   * }
   */

  public String getDocumentPath() {
    return MappingManager.documentPath;
  }

  public void mapDocModelPara(String id, Paragraph paragraph) {

    MappingManager.modelMap.put(id, paragraph);
  }

  public void mapParagraph(String id, XWPFParagraph p) {

    MappingManager.objectMap.put(id, p);
  }

  public void mapRuns(String paragraphId, List<XWPFRun> runList) {
    MappingManager.map.put(paragraphId, runList);
  }

  public void printMap() {

    for (Map.Entry<String, List<XWPFRun>> entry : MappingManager.map.entrySet()) {

      System.out.println(entry.getKey() + "---------------");

      for (XWPFRun run : entry.getValue()) {

        System.out.println("Run : " + run.toString());
      }
    }
  }

  /*
   * public void mapPart(String id, Part part) {
   *
   * objectMap.put(id, part); }
   *
   */
  public void removeParagraph(String id) {


    // docInstance.removeBodyElement(docInstance.getPosOfParagraph((XWPFParagraph)
    // objectMap.get(id)));
    /*
     * XWPFParagraph p = objectMap.get(id); docInstance.getParagraphs().remove(p);
     */
    XWPFParagraph p = MappingManager.objectMap.get(id);
    Paragraph paragraph = MappingManager.modelMap.get(id);

    if (paragraph.getOwnedNode().size() > 0) {
      this.deleteContainments(paragraph);
    }

    int position = MappingManager.docInstance.getPosOfParagraph(p);
    MappingManager.docInstance.removeBodyElement(position);
    MappingManager.map.remove(id);
    MappingManager.objectMap.remove(id);
    MappingManager.modelMap.remove(id);

  }

  public void setDocument(XWPFDocument d) {

    MappingManager.docInstance = d;
  }

  public void setDocumentPath(String documentPath) {
    MappingManager.documentPath = documentPath;
  }



}
